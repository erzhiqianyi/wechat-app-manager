package com.erzhiqian.wechatappmanager.infrastructure.error;

public enum  UnexpectedErrorCode implements ErrorCode{
    UNEXPECTED_ERROR(-1);
    private int code;

    UnexpectedErrorCode(int code) {
        this.code = code;
    }

    @Override
    public int errorCode() {
        return code;
    }
}
