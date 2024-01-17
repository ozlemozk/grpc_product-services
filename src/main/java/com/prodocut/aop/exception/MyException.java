package com.prodocut.aop.exception;

import java.io.Serializable;

public class MyException extends RuntimeException implements Serializable {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
