package com.dhrithi.curewell.backend.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class CurewellException extends RuntimeException{
    private HttpStatus status;
    private String message;
    public CurewellException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
