package com.ssz;

public class NoSuchEmptyInputException extends RuntimeException{

    public NoSuchEmptyInputException() {
        super();
    }

    public NoSuchEmptyInputException(String s) {
        super(s);
    }
}
