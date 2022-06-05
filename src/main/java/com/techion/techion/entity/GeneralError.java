package com.techion.techion.entity;

import org.springframework.http.HttpStatus;



public class GeneralError {

    private HttpStatus status;
    private String message;

    public GeneralError(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
