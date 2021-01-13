package com.erzhiqian.wechatappmanager.api;

import com.erzhiqian.wechatappmanager.domain.exception.DomainException;
import com.erzhiqian.wechatappmanager.domain.exception.EntityAlreadyExistsException;
import com.erzhiqian.wechatappmanager.domain.exception.InvalidEntityException;
import com.erzhiqian.wechatappmanager.domain.exception.MissingEntityException;
import com.erzhiqian.wechatappmanager.infrastructure.error.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static com.erzhiqian.wechatappmanager.infrastructure.error.UnexpectedErrorCode.UNEXPECTED_ERROR;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;


/**
 * @author 二之前一
 * @CreateDate 2020年10月29日
 */
@RestControllerAdvice
@Log4j2
class ErrorHandler {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleEntityAlreadyExistsException(EntityAlreadyExistsException ex, HttpServletRequest request) {
        return handleDomainException(ex, request, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorMessage> handleInvalidEntityException(InvalidEntityException ex, HttpServletRequest request) {
        return handleDomainException(ex, request, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MissingEntityException.class)
    public ResponseEntity<ErrorMessage> handleMissingEntityException(MissingEntityException ex, HttpServletRequest request) {
        return handleDomainException(ex, request, NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest request) {
        log.error(createLog(request, INTERNAL_SERVER_ERROR, UNEXPECTED_ERROR, ex.getMessage()), ex);
        return status(INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(UNEXPECTED_ERROR));
    }

    private ResponseEntity<ErrorMessage> handleDomainException(DomainException ex, HttpServletRequest request, HttpStatus status) {
        log.warn(createLog(request, status, ex.getCode(), ex.getMessage()));
        return status(status)
                .body(new ErrorMessage(ex.getCode(),ex.getMessage()));
    }

    private String createLog(HttpServletRequest request, HttpStatus status, ErrorCode code, String message) {
        return request.getMethod() + " " + request.getRequestURI() + " " + status.value() + " | " + code + " | " + message;
    }
}
