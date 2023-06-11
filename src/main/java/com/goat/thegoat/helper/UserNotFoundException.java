package com.goat.thegoat.helper;

public class UserNotFoundException extends  Exception{
    public UserNotFoundException(){
        super("User with username is already present the records");
    }
    public UserNotFoundException(String msg){
        super(msg);
    }
}
