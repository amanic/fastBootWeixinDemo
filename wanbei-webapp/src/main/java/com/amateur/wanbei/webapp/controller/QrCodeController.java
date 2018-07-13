package com.amateur.wanbei.webapp.controller;

import com.amateur.wanbei.dao.entity.WbUserLoan;
import com.amateur.wanbei.service.annotation.WxController;
import com.amateur.wanbei.service.bean.WbUserLoanVO;
import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.support.QrCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenhaitao on 2018/6/8.
 */
@Slf4j
@WxController
@RequestMapping("qr")
@Api("合同相关接口")
public class QrCodeController {

    @Autowired
    QrCodeService qrCodeService;


    @PostMapping("send")
    @ApiOperation("生成合同")
    public ResultApi sendQrCode(@RequestBody WbUserLoanVO wbUserLoanVO){
        return qrCodeService.sendQrCode(wbUserLoanVO);
    }

    @GetMapping("read")
    @ApiOperation("读取合同")
    public ResultApi<WbUserLoanVO> readQrCode(@ApiParam("id") Integer i){
        return qrCodeService.readQrCode(i);
    }

    @GetMapping("confirm")
    @ApiOperation("借款人确认")
    public ResultApi confirm(@ApiParam("id") Integer i){
        return qrCodeService.confirm(i);
    }


}
