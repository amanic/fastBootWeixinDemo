package com.amateur.wanbei.util;

import com.amateur.wanbei.dao.entity.WbUserBinding;
import com.amateur.wanbei.dao.entity.WbUserProfile;
import com.amateur.wanbei.dao.mapper.WbUserBindingMapper;
import com.amateur.wanbei.dao.mapper.WbUserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaitao on 2018/6/11.
 */
@Service
public class UserInfoUtil {

    @Autowired
    WbUserBindingMapper wbUserBindingMapper;

    @Autowired
    WbUserProfileMapper wbUserProfileMapper;

    public WbUserProfile getCurrentUser(String openId){
        WbUserBinding wbUserBinding = wbUserBindingMapper.selectByOpenId(openId);
        if(null == wbUserBinding){
            return null;
        }
        Integer uid = wbUserBinding.getUid();
        WbUserProfile wbUserProfile = wbUserProfileMapper.selectByPrimaryKey(uid);
        if(null == wbUserProfile){
            return null;
        }
        return wbUserProfile;
    }
}
