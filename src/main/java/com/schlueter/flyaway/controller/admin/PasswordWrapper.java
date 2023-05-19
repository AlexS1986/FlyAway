package com.schlueter.flyaway.controller.admin;

public class PasswordWrapper {
    private String value;

    public PasswordWrapper() {

    }
    public PasswordWrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
