package com.example.ecommerce.Exceptions;

public class UserNotAuthorised extends Exception {
    public UserNotAuthorised(String msg){
        super(msg);
    }
}
