package com.amateur.wanbei.webapp.controller;

import com.amateur.wanbei.service.annotation.WxController;
import com.amateur.wanbei.service.bean.UserInfoVO;
import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.user.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("userInfo")
@WxController
@Api(value = "用户信息接口")
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;


    @GetMapping("getInfo")
    @ApiOperation(value = "获取用户信息")
    public ResultApi<UserInfoVO> userInfo(){
        return userInfoService.getUserInfo();
    }

    @PostMapping("saveInfo")
    @ApiOperation(value = "保存用户信息")
    public ResultApi<String> saveInfo(@RequestBody UserInfoVO userInfoVO){
         userInfoService.saveInfo(userInfoVO);
         return ResultApi.success("保存成功");
    }

    @PostMapping("editInfo")
    @ApiOperation(value = "编辑用户信息")
    public ResultApi<String> editInfo(@RequestBody UserInfoVO userInfoVO){
        userInfoService.editInfo(userInfoVO);
        return ResultApi.success("编辑成功");
    }

}
