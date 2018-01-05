package com.lxy.demo.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("error_code")
    public String errorCode;

    @JsonProperty("description")
    public String description;

    public ErrorResponse(String errorCode,String description)
    {
        this.errorCode=errorCode;
        this.description=description;
    }
}
