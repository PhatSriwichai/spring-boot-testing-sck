package com.aiwine.train.controller.response;

import java.util.Date;

public class ExceptionResponse {

    private Date timestamp = new Date();
    private String message;
    private String detail;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
