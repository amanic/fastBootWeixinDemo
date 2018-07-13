package com.amateur.wanbei.service.exception.web;

import lombok.Data;

@Data
public class BizException extends BaseException{

    public BizException(Exception e) {
        super(e);
    }

    public BizException(String msg) {
        super(msg);
    }

    public BizException(BaseResultCode baseResultCode) {
        super(baseResultCode);
    }

    public BizException(BaseResultCode baseResultCode, String errorMsg) {
        super(baseResultCode, errorMsg);
    }


}
