package com.ssz;

import java.io.IOException;

public class UserDataError extends IOException {

    public UserDataError(String message) {
        super(message);
        System.out.println("Отсутствует обязательное поле " + message);
    }
}
