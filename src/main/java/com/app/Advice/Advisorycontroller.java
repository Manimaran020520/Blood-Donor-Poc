package com.app.Advice;


import com.app.Exception.DataNotFoundException;
import com.app.Exception.bloodgroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class Advisorycontroller {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errormap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(i -> {
            errormap.put(i.getField(), i.getDefaultMessage());
        });
        return errormap;
    }
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(bloodgroupNotFoundException.class)
    public Map<String,String>handleBusinessException(bloodgroupNotFoundException ex){
        Map<String, String> errormap = new HashMap<>();
        errormap.put("errorMessage", ex.getMessage());
        return errormap;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(DataNotFoundException.class)
    public Map<String,String>handleexception(DataNotFoundException ex){
        Map<String, String> errormap1 = new HashMap<>();
        errormap1.put("errorMessage", ex.getMessage());
        return errormap1;
    }

}
