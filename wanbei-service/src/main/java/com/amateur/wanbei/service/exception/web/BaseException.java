/**
 *
 */
package com.amateur.wanbei.service.exception.web;

/**
 *
 * @author oldwang
 */
public class BaseException extends RuntimeException {
    private BaseResultCode baseResultCode;
    /** */
    private static final long serialVersionUID = 2298385767945343574L;

    public BaseException() {
        super();
    }

    public BaseException(String msg) {
        super(msg);
    }

    /**
     * @param e
     */
    public BaseException(Exception e) {
        super(e);
    }

    /**
     * @param msg
     * @param e
     */
    public BaseException(String msg, Exception e) {
        super(msg, e);
    }

    public BaseException(BaseResultCode baseResultCode) {
        super(baseResultCode.getCode() + ":" + baseResultCode.getMessage());
        this.baseResultCode = baseResultCode;
    }

    public BaseException(BaseResultCode baseResultCode, String errorMsg) {
        this(baseResultCode.getCode() + ":" + baseResultCode.getMessage() + "," + errorMsg);
        this.baseResultCode = baseResultCode;
    }

    public BaseResultCode getBaseResultCode() {
        return baseResultCode;
    }
}
