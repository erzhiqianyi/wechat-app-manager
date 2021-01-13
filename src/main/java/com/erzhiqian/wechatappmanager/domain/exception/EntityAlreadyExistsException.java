package com.erzhiqian.wechatappmanager.domain.exception;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;


/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class EntityAlreadyExistsException extends DomainException {

    public EntityAlreadyExistsException(ErrorCode code, String message) {
        super(code, message);
    }
}
