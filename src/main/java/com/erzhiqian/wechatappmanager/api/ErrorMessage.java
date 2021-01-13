package com.erzhiqian.wechatappmanager.api;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;
import com.erzhiqian.wechatappmanager.infrastructure.error.UnexpectedErrorCode;
import lombok.Data;

/**
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@Data
public class ErrorMessage {

    private static final String INNER_ERROR_MSG = "inner error.";
    private Integer errorCode;

    private String errorMessage;

    public ErrorMessage(ErrorCode errorCode, String errorMessage) {
        this.errorCode = errorCode.errorCode();
        this.errorMessage = errorMessage;
    }

    public ErrorMessage(ErrorCode errorCode) {
        this(errorCode,INNER_ERROR_MSG);
    }
}
