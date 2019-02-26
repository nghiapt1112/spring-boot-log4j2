package com.mixi.demo.don.vi;

import com.mixi.demo.infrastructure.exception.DomainException;

public class DonViException extends DomainException {

    public DonViException(String errorCode, String message) {
        super(errorCode, message);
    }
}
