package com.erzhiqian.wechatappmanager.domain.exception;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;

import java.util.function.Supplier;


/**
 * @author 二之前一
 * @CreateDate 2020年10月31日
 */
public class PreCondition {
    private boolean condition;

    private PreCondition(boolean condition) {
        this.condition = condition;
    }

    public static PreCondition when(boolean condition) {
        return new PreCondition(condition);
    }

    public void thenInvalidEntity(ErrorCode code, String message) {
        thenThrow(() -> new InvalidEntityException(code, message));
    }

    public void thenEntityAlreadyExists(ErrorCode code, String message) {
        thenThrow(() -> new EntityAlreadyExistsException(code, message));
    }

    public void thenMissingEntity(ErrorCode code, String message) {
        thenThrow(() -> new MissingEntityException( code,message));
    }

    private void thenThrow(Supplier<DomainException> exceptionCreator) {
        if (condition) {
            throw exceptionCreator.get();
        }
    }
}
