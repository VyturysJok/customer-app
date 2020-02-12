package com.enorkus.academy.validate;

public abstract class Validator<T> {
    public abstract void validate(T attribute, String message);
}
