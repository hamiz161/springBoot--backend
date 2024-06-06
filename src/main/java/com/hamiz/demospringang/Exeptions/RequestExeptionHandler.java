package com.hamiz.demospringang.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class RequestExeptionHandler {

    @ExceptionHandler (RequestNotFoundExeption.class)

    public ResponseEntity<ErrorObject> handelStudentNotFoundException(RequestNotFoundExeption ex, WebRequest request){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());

        errorObject.setTimesTamp(new Date());
        return  new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);
    }


}
