package com.amateur.wanbei.service.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "客户信息实体类")
public class UserInfoVO implements Serializable {

    @ApiModelProperty("用户id,全局称作 uid")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("身份证号")
    private String idCard;

    @ApiModelProperty("备用手机1")
    private String sparePhone1;

    @ApiModelProperty("备用手机2")
    private String sparePhone2;

    @ApiModelProperty("身份证正面照片")
    private String frontPic;

    @ApiModelProperty("身份证背面照片")
    private String backPic;

    @ApiModelProperty("身份证手持照片")
    private String handPic;

    @ApiModelProperty("微信头像")
    private String headImgUrl;

    @ApiModelProperty("昵称")
    private String nickName;
}
