package com.amateur.wanbei.webapp.controller;

import com.amateur.wanbei.service.module.Wx;
import com.amateur.wanbei.service.util.WxRedirectUtils;
import com.amateur.wanbei.service.util.WxWebUtils;
import com.amateur.wanbei.service.web.WxOAuth2Callback;
import com.amateur.wanbei.service.web.WxUserManager;
import com.amateur.wanbei.service.web.WxWebUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;


//自定义微信统一入口方法
@Controller
@RequestMapping("wechat/auth")
@Slf4j
public class AuthController {

    private static final String CODE_PREFIX = "code=";

    @Autowired
    private WxUserManager wxUserManager;

    /**
     * 登录回调函数，可以通过构造函数指定，也可以直接注入进来
     */
    @Autowired(required = false)
    private WxOAuth2Callback wxOAuth2Callback;

    @GetMapping(value = "entry")
    public String entrance(HttpServletRequest request, HttpServletResponse response, String url, String suf) throws Exception{
        int i= 0;
        String s = url;
        url = url+"/#/"+suf;
        WxWebUser sessionUser = WxWebUtils.getWxWebUserFromSession(request);
        if (sessionUser  != null) {
            return "redirect:"+url;
        }
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        if (!StringUtils.isEmpty(code)) {
            WxWebUser wxWebUser = wxUserManager.getWxWebUser(code);
            if (wxWebUser != null && wxWebUser.getOpenId() != null) {
                if (wxOAuth2Callback != null) {
                    wxOAuth2Callback.after(new WxOAuth2Callback.WxOAuth2Context(wxWebUser, state, response, request));
                }
                WxWebUtils.setWxWebUserToSession(request, wxWebUser);
                // 拿到之后最好是重定向到没有code的页面，否则code会暴露，带来安全问题
                // 但本身这个code就是只能用一次的，故暂时不增加一次重定向
                return "redirect:"+url;
            }
        }
        String requestUrl = getRequestUrl(request)+"?url="+s+"&suf="+suf;
        log.info("WxOAuth2Interceptor request url is : " + requestUrl);
        // 如果重定向到授权，则肯定可以获得信息，但是如果重定向到基本，则无法获得信息，所以默认重定向到授权
        String redirectUrl = WxRedirectUtils.redirect(requestUrl, false);
        log.info("WxOAuth2Interceptor redirect to auth url : " + redirectUrl);
        return "redirect:"+redirectUrl;

    }


    private String getRequestUrl(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(Wx.Environment.instance().getCallbackHost())) {
            sb.append(request.getRequestURL().toString());
        } else {
            URI uri = URI.create(request.getRequestURL().toString());
            sb.append(uri.getScheme() + "://");
            sb.append(Wx.Environment.instance().getCallbackHost());
            sb.append(uri.getPath());
        }
        // 强制移除code参数，如果不移除的话，会导致微信跳转回来带两个code参数，这样是有问题的
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString) && queryString.contains(CODE_PREFIX)) {
            String[] queryParams = queryString.split("&");
            for (String param : queryParams) {
                if (!param.contains(CODE_PREFIX)) {
                    sb.append(param).append('&');
                }
            }
            if (sb.charAt(sb.length() - 1) == '&') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

}
