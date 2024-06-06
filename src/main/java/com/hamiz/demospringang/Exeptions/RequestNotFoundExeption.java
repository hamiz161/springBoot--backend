package com.hamiz.demospringang.Exeptions;

public class RequestNotFoundExeption extends RuntimeException{

    public RequestNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
    public RequestNotFoundExeption(String message) {
        super(message);
    }


}
