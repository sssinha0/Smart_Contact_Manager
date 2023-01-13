package com.infy.smartcontact.dao;


public class ErrorReponse {

    private String errorName;

    public ErrorReponse(String errorName) {
        this.errorName = errorName;
    }

    public ErrorReponse() {
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
