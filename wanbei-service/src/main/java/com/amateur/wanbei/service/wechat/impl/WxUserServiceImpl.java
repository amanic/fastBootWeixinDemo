package com.amateur.wanbei.service.wechat.impl;


import com.amateur.wanbei.dao.entity.WbUserBinding;
import com.amateur.wanbei.dao.mapper.WbUserBindingMapper;
import com.amateur.wanbei.service.module.user.WxUser;
import com.amateur.wanbei.service.wechat.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    WbUserBindingMapper wbUserBindingMapper;


    @Override
    public boolean storeWxUserProfile(WxUser wxUser) {
        WbUserBinding wbUserBinding = new WbUserBinding();
        wbUserBinding.setOpenId(wxUser.getOpenId());
//        wbUserBindingMapper.insertSelective();
        return false;
    }

    @Override
    public boolean updateWxUserProfile(WxUser profile) {

        return false;
    }

    @Override
    public boolean isWxUserProfileStored(String openId) {
        WbUserBinding wbUserBinding = wbUserBindingMapper.selectByOpenId(openId);
        if(null==wbUserBinding){
            return false;
        }
        return true;
    }

    @Override
    public void UnsubscribeWxUser(String openId) {

    }
}
