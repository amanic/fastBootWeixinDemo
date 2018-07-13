package com.amateur.wanbei.service.mvc.exceptionresolver;

import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.exception.web.BaseException;
import com.amateur.wanbei.service.exception.web.BaseResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebExceptionResolver implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionResolver.class);
    private boolean isLogToDB = false;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
        StringBuilder urlBulider = new StringBuilder();
        if (obj instanceof HandlerMethod) {
            RequestMapping classAnnontion = AnnotationUtils.getAnnotation(((HandlerMethod) obj).getBeanType(), RequestMapping.class);
            RequestMapping methodAnnontion = AnnotationUtils.getAnnotation(((HandlerMethod) obj).getMethod(), RequestMapping.class);
            String[] subUrl = null;
            if (methodAnnontion != null) {
                subUrl = methodAnnontion.value();
            }
            String[] prefixUrl = null;
            if (classAnnontion != null) {
                prefixUrl = classAnnontion.value();
            }
            if (prefixUrl != null) {
                urlBulider.append(StringUtils.arrayToDelimitedString(prefixUrl, ";")).append("/");
            }
            if (subUrl != null) {
                urlBulider.append(StringUtils.arrayToDelimitedString(subUrl, ";"));
            }
        } else {
            urlBulider.append(obj.getClass().getName());
        }
        ModelAndView result = new ModelAndView("jsonView");
        ResultApi<?> dataNew = null;
        if (e instanceof BaseException) {
            dataNew = getResultDataNew((BaseException) e);
        } else {
            dataNew = getResultDataNew(e);
        }
        result.addObject("code", dataNew.getCode());
        result.addObject("message", dataNew.getMessage());
//        tool.error(e);
//        response.addHeader(DebugTool.HEADER_NAME,tool.getResponse());
        return result;
    }

    public boolean getIsLogToDB() {
        return isLogToDB;
    }

    public void setIsLogToDB(boolean isLogToDB) {
        this.isLogToDB = isLogToDB;
    }

    private ResultApi<?> getResultDataNew(BaseException e) {
        BaseResultCode baseResultCode = e.getBaseResultCode();
        if (baseResultCode == null) {
            if (StringUtils.isEmpty(e.getMessage())) {
                return ResultApi.fail();
            } else {
                return ResultApi.fail(e.getMessage());
            }
        } else {
            ResultApi<Object> resultApi = ResultApi.fail().setCode(baseResultCode.getCode()).setMessage(baseResultCode.getMessage());
            if (!StringUtils.isEmpty(e.getMessage())) {// 优先使用message
                resultApi.setMessage(e.getMessage());
            }
            return resultApi;
        }
    }

    private ResultApi<?> getResultDataNew(Exception e) {
        return ResultApi.fail();
    }
}
