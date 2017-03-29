package com.ms2003.timesheet.web.service;

import com.ms2003.timesheet.business.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hr on 29/3/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public String handleBaseException(BaseException e){
        return e.getMessage();
    }

}
