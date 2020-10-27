package com.erzhiqian.wechatappmanager.api;

import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;
import lombok.Data;

/**
 * @author 二之前一
 */
@Data
public class ErrorMessage {

    private Integer errorCode;

    private String errorMessage;

    public ErrorMessage(ErrorCode errorCode, String errorMessage) {
        this.errorCode = errorCode.errorCode();
        this.errorMessage = errorMessage;
    }
}
