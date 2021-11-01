package com.postupaylo.yandex.praktikum.exceptions;

public class NondeliverableException extends Exception {
    public NondeliverableException(String errorMessage){
        super(errorMessage);
    }
}
