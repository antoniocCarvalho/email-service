package com.carvalho.emailservice.core.exceptions;

public class EmailServiceExcepetion  extends RuntimeException{
    public EmailServiceExcepetion(String message){
        super(message);
    }

    public EmailServiceExcepetion(String message, Throwable cause){
        super(message, cause);
    }

}
