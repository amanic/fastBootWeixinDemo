package com.amateur.wanbei.webapp;

import com.amateur.wanbei.service.annotation.*;
import com.amateur.wanbei.service.module.credential.WxJsTicketManager;
import com.amateur.wanbei.service.module.event.WxEvent;
import com.amateur.wanbei.service.module.extend.WxCard;
import com.amateur.wanbei.service.module.extend.WxQrCode;
import com.amateur.wanbei.service.module.js.WxJsApi;
import com.amateur.wanbei.service.module.js.WxJsConfig;
import com.amateur.wanbei.service.module.media.WxMedia;
import com.amateur.wanbei.service.module.media.WxMediaManager;
import com.amateur.wanbei.service.module.message.*;
import com.amateur.wanbei.service.module.user.WxTagUser;
import com.amateur.wanbei.service.module.user.WxUser;
import com.amateur.wanbei.service.module.web.WxRequest;
import com.amateur.wanbei.service.module.web.WxRequestBody;
import com.amateur.wanbei.service.module.web.session.WxSession;
import com.amateur.wanbei.service.service.WxApiService;
import com.amateur.wanbei.service.service.WxExtendService;
import com.amateur.wanbei.service.support.QrCodeService;
import com.amateur.wanbei.service.util.WxWebUtils;
import com.amateur.wanbei.service.web.WxWebUser;
import com.amateur.wanbei.service.wechat.WxUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WxApplication(menuAutoCreate = true)
@WxController
@Slf4j
@ComponentScan(value = {"com.amateur.wanbei.webapp","com.amateur.wanbei.service","com.amateur.wanbei.util"})
@EnableSwagger2
public class WanbeiApplication {

	@Autowired
	WxApiService wxApiService;

	@Autowired
	WxMediaManager wxMediaManager;

	@Autowired
	WxMessageTemplate wxMessageTemplate;

	@Autowired
	WxExtendService wxExtendService;

	@Autowired
	WxJsTicketManager wxJsTicketManager;

	@Autowired
    WxUserService wxUserService;

	@Autowired
	QrCodeService qrCodeService;



	public static void main(String[] args) {
		SpringApplication.run(WanbeiApplication.class, args);
	}



	/**
	 * 定义微信菜单
	 */
	@WxButton(type = WxButton.Type.VIEW,//view表示网页类型 点击之后跳转到相应的url
			group = WxButton.Group.LEFT,
			url = "http://haron.natapp1.cc/wechat/auth/entry?url=http://haron.natapp1.cc/index.html&suf=home",
			name = "首页",
			main = true)
	public void left(WxUser wxUser) {
	}

	/**
	 * 定义微信菜单
	 */
	@WxButton(type = WxButton.Type.VIEW,//view表示网页类型 点击之后跳转到相应的url
			group = WxButton.Group.MIDDLE,
			url = "http://haron.natapp1.cc/wechat/auth/entry?url=http://haron.natapp1.cc/index.html&suf=dealInfo",
			name = "打借条",
			main = true)
	public void middle(WxUser wxUser) {
	}



	/**
	 * 定义微信菜单
	 */
	@WxButton(type = WxButton.Type.VIEW,//view表示网页类型 点击之后跳转到相应的url
			group = WxButton.Group.RIGHT,
			url = "http://haron.natapp1.cc/wechat/auth/entry?url=http://haron.natapp1.cc/index.html&suf=personal",
			name = "个人中心",
			main = true)
	public void right(WxUser wxUser) {
	}






	/**
	 * 接受微信事件
	 *
	 * @param wxRequest
	 * @param wxUser
	 */
	@WxEventMapping(type = WxEvent.Type.UNSUBSCRIBE)
	public void unsubscribe(WxRequest wxRequest, WxUser wxUser) {
	    wxUserService.UnsubscribeWxUser(wxUser.getOpenId());
		System.out.println("取消关注" + wxUser.getOpenId());
//        System.out.println(wxUser.getNickName() + "退订了公众号");
	}

	/**
	 * 接受微信事件
	 *
	 * @param wxRequest
	 * @param wxUser
	 */
	@WxEventMapping(type = WxEvent.Type.SUBSCRIBE)
	public String subscribe(WxRequest wxRequest, WxUser wxUser) {
		log.info("------------"+wxRequest.getBody().getContent());
        boolean b = wxUserService.isWxUserProfileStored(wxUser.getOpenId());
        if(b){
            wxUserService.updateWxUserProfile(wxUser);
        }else{
            wxUserService.storeWxUserProfile(wxUser);
        }
        return "欢迎您关注本公众号，本公众号使用FastBootWeixin框架开发，简单极速开发微信公众号，你值得拥有:推荐者";
	}

	@WxEventMapping(type = WxEvent.Type.SCAN)
	public String scan(WxRequest wxRequest, WxUser wxUser) {
		System.out.println("扫描二维码" + wxUser.getOpenId());
		return "触发扫描二维码";
	}

	/**
	 * 接受微信事件
	 *
	 */
	@WxEventMapping(type = WxEvent.Type.LOCATION)
	public WxMessage location(WxRequestBody.LocationReport location) {
		return WxMessage.News.builder()
				.addItem("接受到您的地理位置", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://mxixm.com")
				.addItem("纬度" + location.getLatitude(), "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://smc24f.natappfree.cc/vendor/82")
				.addItem("经度" + location.getLongitude(), "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2a0e54054e2fb7c0&redirect_uri=http://smc24f.natappfree.cc/vendor/82&response_type=code&scope=snsapi_base&state#wechat_redirect")
				.build();
	}


	/**
	 * 接受微信事件
	 *
	 * @param wxUser
	 */
	@WxEventMapping(type = WxEvent.Type.TEMPLATESENDJOBFINISH)
	public void template(WxRequestBody.Template template, WxUser wxUser) {
		// 模板消息发送完成的回调
		System.out.println(template.toString());
	}

	/**
	 * 接受用户文本消息，异步返回文本消息
	 *
	 * @param content
	 * @return the result
	 */
	@WxMessageMapping(type = WxMessage.Type.TEXT)
	@WxAsyncMessage
	public String text(WxRequest wxRequest, String content) {
		WxSession wxSession = wxRequest.getWxSession();
		if (wxSession != null && wxSession.getAttribute("last") != null) {
			String s = wxSession.getAttribute("last")+"";
			wxSession.setAttribute("last",content);
			return "上次收到消息内容为" + s +"; 本次消息是"+content;
		}
		wxSession.setAttribute("last",content);
		return "收到消息内容为" + content;
	}

	/**
	 * 接受用户文本消息，同步返回图文消息
	 *
	 * @param content
	 * @return the result
	 */
	@WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "1*")
	public String message(WxSession wxSession, String content) {
		wxSession.setAttribute("last", content);
		return "收到文本内容为" + content;
	}

	/**
	 * 接受用户文本消息，异步返回文本消息
	 *
	 * @param content
	 * @return the result
	 */
	@WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "2*")
	@WxAsyncMessage
	public String text2(WxRequestBody.Text text, String content) {
		boolean match = text.getContent().equals(content);
		return "收到消息内容为" + content + "!结果匹配！" + match;
	}


	@WxMessageMapping(type = WxMessage.Type.LOCATION)
	@WxAsyncMessage
	public String textLocation(WxRequestBody.Location location) {
		return location.toString();
	}

	@WxMessageMapping(type = WxMessage.Type.IMAGE)
	@WxAsyncMessage
	// 发送图片会自动上传到微信服务器 返回url
	public WxMessage textImg(WxRequestBody.Image image) {
//		return image.getPicUrl();
		return WxMessage.imageBuilder().mediaUrl(image.getPicUrl()).build();
	}

	@WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "群发*")
	@WxAsyncMessage
	public WxMessage groupMessage(String content) {
		String tagId = content.substring("群发".length());
		return WxMessage.Text.builder().content("pKS9_xJ6hvk4uLPOsHNPmnVRw0vE").toGroup(Integer.parseInt(tagId)).build();
	}


	@WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "模板*")
	public String templateMessage(WxRequestBody.Text text) {
		WxTemplateMessage templateMessage = WxMessage.templateBuilder()
				.data("keynote1", "1324.76", "#FF0000")
				.data("keynote2", "2017-10-25", "#0000FF")
				.templateId("IIXwm9TJ5F-tAXPdqP7D4xL6rRK-lVwpNWlVRIsZ9Wo")
				.toUser(text.getFromUserName())
//                .url("http://www.baidu.com")
				.build();
		wxMessageTemplate.sendTemplateMessage(templateMessage);
		return "模板消息已发送";
	}

	@WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "卡券*")
	public List<WxMessage> cardMessage(String content) {
		Integer tagId = Integer.parseInt(content.substring("卡券".length()));
		WxTagUser.UserList userList = wxApiService.listUserByTag(WxTagUser.listUser(tagId));
		return userList.getOpenIdList().stream().flatMap(u -> {
			List<WxMessage> l = new ArrayList();
			l.add(WxMessage.WxCard.builder().cardId("pKS9_xMBmNqlcWD-uAkD1pOy09Qw").toUser(u).build());
			l.add(WxMessage.WxCard.builder().cardId("pKS9_xPsM7ZCw7BW1U2lRRN-J2Qg").toUser(u).build());
			return l.stream();
		}).collect(Collectors.toList());
	}

	@RequestMapping("cards")
	public List<WxCard> cards() {
		return wxApiService.getCards(WxCard.ListSelector.of(WxCard.Status.CARD_STATUS_NOT_VERIFY))
				.getCardIdList().stream().map(id -> {
					return wxApiService.cardInfo(WxCard.CardSelector.info(id));
				}).collect(Collectors.toList());
	}

	@RequestMapping("card")
	public WxCard card() {
		return wxApiService.cardInfo(WxCard.CardSelector.info("pKS9_xMBmNqlcWD-uAkD1pOy09Qw"));
	}


	@RequestMapping("mediaUpload")
	public String mediaUpload() {
		return wxMediaManager.addTempMedia(WxMedia.Type.IMAGE, new FileSystemResource("E:/test.png"));
	}

	@RequestMapping("send")
	@ResponseBody
	public String testWeb(String openId,String name) {
		WxUserMessage wxUserMessage = WxMessage.News.builder().addItem(name,"晚上好啊测试一条推送","https://alpha.wallhaven.cc/wallpapers/thumb/small/th-653749.jpg","http://tczmh.club/bz/").build();
		wxMessageTemplate.sendMessage(openId, wxUserMessage);
		return "";
//		return WxMessage.News.builder().addItem("董浏榆","傻叉","https://alpha.wallhaven.cc/wallpapers/thumb/small/th-653221.jpg","https://www.baidu.com/s?wd=initialingbean&tn=98012088_5_dg&ch=11").build();
	}

	@RequestMapping("sendGroup")
	@ResponseBody
	@Deprecated
	public WxMessage sendGroup(String text) {
		return WxMessage.textBuilder().content(text).toGroup().build();
	}

	@RequestMapping("qrcode")
	@ResponseBody
	@Deprecated
	public WxQrCode.Result qrcode() {
		return wxExtendService.createQrCode(WxQrCode.builder().temporary(1).build());
	}

	@RequestMapping("wx/bind")
	@ResponseBody
	public String login() {
		WxWebUser wxWebUser = WxWebUtils.getWxWebUserFromSession();
		return wxWebUser.getOpenId();
	}

	@PostMapping("doError")
	@ResponseBody
	@Deprecated
	public WxMessage err(String text) {
		List<WxMessageBody.News.Item> list = new ArrayList<>();
		WxMessageBody.News.Item item = new WxMessageBody.News.Item();
		item.setPicUrl("https://alpha.wallhaven.cc/wallpapers/thumb/small/th-653749.jpg");
		item.setUrl("http://tczmh.club/bz/");
		item.setDescription("测试一下描述！");
		item.setTitle("测试一下标题");
		list.add(item);
		// 群发是不支持news的  只支持mpnews
//		return WxMessage.newsBuilder().addItems(list).toGroup("oqJUswk1biizI3O8lzM3_QKewbQM").build();
		return WxMessage.textBuilder().content(text).toGroup("oqJUswk1biizI3O8lzM3_QKewbQM").build();
	}

	@RequestMapping("getWxJsConfig")
	@ResponseBody
	public WxJsConfig wxJsConfig() {
		return wxJsTicketManager.getWxJsConfigFromRequest(WxJsApi.getLocation);
	}


}
