package com.enorkus.academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class MandatoryValueMissingException extends RuntimeException {
    public MandatoryValueMissingException(String message) {
        super(message);
    }
}
