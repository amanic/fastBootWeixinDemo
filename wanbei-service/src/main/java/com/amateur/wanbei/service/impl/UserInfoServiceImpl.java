package com.amateur.wanbei.service.impl;

import com.amateur.wanbei.dao.entity.WbUserBinding;
import com.amateur.wanbei.dao.entity.WbUserProfile;
import com.amateur.wanbei.dao.mapper.WbUserBindingMapper;
import com.amateur.wanbei.dao.mapper.WbUserProfileMapper;
import com.amateur.wanbei.service.bean.UserInfoVO;
import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.exception.web.BizException;
import com.amateur.wanbei.service.service.WxApiService;
import com.amateur.wanbei.service.user.UserInfoService;
import com.amateur.wanbei.service.util.WxWebUtils;
import com.amateur.wanbei.service.web.WxWebUser;
import com.amateur.wanbei.util.UserInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by chenhaitao on 2018/6/11.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{


    @Autowired
    UserInfoUtil userInfoUtil;

    @Autowired
    WbUserProfileMapper wbUserProfileMapper;

    @Autowired
    WbUserBindingMapper wbUserBindingMapper;

    @Autowired
    WxApiService wxApiService;

    @Override
    public ResultApi<UserInfoVO> getUserInfo() {
        WxWebUser wxWebUser = WxWebUtils.getWxWebUserFromSession();
        String openId = WxWebUtils.getWxWebUserFromSession().getOpenId();
        WbUserProfile wbUserProfile = userInfoUtil.getCurrentUser(openId);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setHeadImgUrl(wxApiService.getUserInfo(openId).getHeadImgUrl());
        userInfoVO.setNickName(wxApiService.getUserInfo(openId).getNickName());
        if(null==wbUserProfile){
            return ResultApi.success(userInfoVO);
        }
        userInfoVO.setName(wbUserProfile.getName());
        userInfoVO.setMobile(wbUserProfile.getMobile());
        userInfoVO.setIdCard(wbUserProfile.getIdCard());
        userInfoVO.setId(wbUserProfile.getId());
        userInfoVO.setBackPic(wbUserProfile.getBackPic());
        userInfoVO.setFrontPic(wbUserProfile.getFrontPic());
        userInfoVO.setHandPic(wbUserProfile.getHandPic());
        userInfoVO.setSparePhone1(wbUserProfile.getSparePhone1());
        userInfoVO.setSparePhone2(wbUserProfile.getSparePhone2());
        return ResultApi.success(userInfoVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveInfo(UserInfoVO userInfoVO) {
        if (userInfoVO.getId()!=null){
            throw new BizException("请勿上传uid");
        }
        WbUserProfile wbUserProfile = new WbUserProfile();
        BeanUtils.copyProperties(userInfoVO,wbUserProfile);
        wbUserProfileMapper.insertSelective(wbUserProfile);
        //微信绑定表插入.
        int uid = wbUserProfile.getId();
        String openId = WxWebUtils.getWxWebUserFromSession().getOpenId();

        WbUserBinding wbUserBinding = new WbUserBinding();
        wbUserBinding.setOpenId(openId);
        wbUserBinding.setUid(uid);
        wbUserBinding.setCreateTime(new Date());
        wbUserBinding.setUpdateTime(new Date());
        wbUserBindingMapper.insertSelective(wbUserBinding);
    }

    @Override
    public void editInfo(UserInfoVO userInfoVO) {
        if (userInfoVO.getId()==null){
            throw new BizException("uid不可为空");
        }
        WbUserProfile wbUserProfile = new WbUserProfile();
        BeanUtils.copyProperties(userInfoVO,wbUserProfile);
        wbUserProfileMapper.updateByPrimaryKeySelective(wbUserProfile);
    }
}
