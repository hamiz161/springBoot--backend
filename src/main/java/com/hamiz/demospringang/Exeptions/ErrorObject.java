package com.hamiz.demospringang.Exeptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObject {
    private Integer statusCode;
    private String message ;
    private Date timesTamp;
    private String request;

}
