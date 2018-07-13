package com.amateur.wanbei.service.wechat;

import com.amateur.wanbei.service.module.user.WxUser;

public interface WxUserService {

    /**
     * 存储微信用户信息
     *
     * @return
     */
    boolean storeWxUserProfile(WxUser profile);


    /**
     * 更新微信用户信息
     *
     * @return
     */
    boolean updateWxUserProfile(WxUser profile);


    /**
     * 已关注微信用户数据是否已保存
     * @param profile
     * @throws Exception
     */
    boolean isWxUserProfileStored(String openId);

    /**
     * 用户取消关注处理
     * @param openId
     * @throws Exception
     */
    void UnsubscribeWxUser(String openId);
}

