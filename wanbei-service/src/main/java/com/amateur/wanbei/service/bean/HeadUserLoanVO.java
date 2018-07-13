package com.amateur.wanbei.service.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class HeadUserLoanVO extends PageUtil{

    @ApiModelProperty("出借人姓名")
    private String name;
    
    @ApiModelProperty("借款人姓名")
    private String loanName;
    
    @ApiModelProperty("默认0自己借出，1查询自己借款的")
    private int type = 0; 
    
    @ApiModelProperty("借款状态0出借中1出借完成")
    private Integer loanType; 
    
}
