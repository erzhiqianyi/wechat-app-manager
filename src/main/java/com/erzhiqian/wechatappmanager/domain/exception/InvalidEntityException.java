package com.erzhiqian.wechatappmanager.domain.exception;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;


public class InvalidEntityException extends DomainException{

    public InvalidEntityException(ErrorCode code, String message) {
        super(code, message);
    }
}
