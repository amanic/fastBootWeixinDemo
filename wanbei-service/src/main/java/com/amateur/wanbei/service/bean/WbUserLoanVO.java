package com.amateur.wanbei.service.bean;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by chenhaitao on 2018/6/11.
 */
@Data
@ApiModel
public class WbUserLoanVO {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("uid")
    private Integer uid;

    @ApiModelProperty("出借人姓名")
    private String name;

    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty("借款时间")
    private String loanStartTime;

    @ApiModelProperty("还款时间")
    private String loanEndTime;

    @ApiModelProperty("id")
    private Integer loanUid;

    @ApiModelProperty("借款人姓名")
    private String loanName;

    @ApiModelProperty("id")
    private String account;

    @ApiModelProperty("id")
    private Integer delete;

    @ApiModelProperty("id")
    private String createTime;

    @ApiModelProperty("id")
    private String updateTime;

    @ApiModelProperty("借款状态")
    private Integer loanType;
    
}

