package com.erzhiqian.wechatappmanager.domain.exception;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;

/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public enum  WechatAppErrorCode implements ErrorCode {

    ;

    WechatAppErrorCode(int code) {
        this.code = code;
    }

    private int code;


    @Override
    public int errorCode() {
        return code;
    }
}
