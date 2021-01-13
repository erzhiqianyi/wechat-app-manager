package com.erzhiqian.wechatappmanager.domain.exception;


import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;

/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class DomainException extends RuntimeException{
    private ErrorCode code;

    public DomainException(ErrorCode code,String message) {
        super(message);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}
