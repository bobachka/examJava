package com.stormnet.fugeresfx.exeptions;

public class IncorrectShapeException extends Exception{
    public IncorrectShapeException(String message) {
        super(message);
        System.out.println(message);
    }
}
