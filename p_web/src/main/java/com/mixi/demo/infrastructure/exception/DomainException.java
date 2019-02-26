package com.mixi.demo.infrastructure.exception;

import lombok.Getter;

public class DomainException extends RuntimeException {

    @Getter
    protected String errorCode;

    public DomainException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public Object getErrorResponse() {
        return new Error(this.errorCode, this.getMessage());
    }
}
