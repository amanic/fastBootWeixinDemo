package com.amateur.wanbei.service.module.param;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by chenhaitao on 2018/6/8.
 */
@Data
public class QrCodeGeneParam {

    private BigDecimal loanAmount;

    private String loanDate;

    private String payDate;

    private String lenderName;

    private String borrowerName;
}
