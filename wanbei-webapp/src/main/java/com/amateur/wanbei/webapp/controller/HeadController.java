package com.amateur.wanbei.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amateur.wanbei.service.annotation.WxController;
import com.amateur.wanbei.service.bean.HeadUserLoanVO;
import com.amateur.wanbei.service.bean.WbUserLoanVO;
import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.support.QrCodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lidong on 2018/6/11.
 */
@WxController
@RequestMapping("head")
@Api("合同相关接口")
public class HeadController {

    @Autowired
    QrCodeService qrCodeService;
    
    @PostMapping("getUserLoanList")
    @ApiOperation("首页查询借款列表")
    public ResultApi<List<WbUserLoanVO>> getUserLoanList(@RequestBody HeadUserLoanVO headUserLoanVO){
        return qrCodeService.getUserLoanList(headUserLoanVO);
    }
}
