package com.example.helloworld;

public class MyCustomException extends RuntimeException{
    Integer code;
    public MyCustomException() {
        super();
        this.code = 200;
    }

    public MyCustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
