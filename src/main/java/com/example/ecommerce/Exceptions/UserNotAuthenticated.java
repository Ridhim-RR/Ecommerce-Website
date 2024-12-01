package com.example.ecommerce.Exceptions;

public class UserNotAuthenticated extends Exception {
    public UserNotAuthenticated(String msg){
        super(msg);
    }
}
