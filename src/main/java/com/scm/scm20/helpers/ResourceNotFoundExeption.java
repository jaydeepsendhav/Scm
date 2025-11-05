package com.scm.scm20.helpers;


public class ResourceNotFoundExeption extends RuntimeException{

    public ResourceNotFoundExeption(String message){
        super(message);
    }

    public ResourceNotFoundExeption(){
        super("Resource Not Found");
    }

}
