package com.example.BloodDonor.CustomExceptionHandler;

import com.example.BloodDonor.CustomException.AlreadyExistsException;
import com.example.BloodDonor.CustomException.CustomException;
import com.example.BloodDonor.CustomException.DataNotFoundException;
import com.example.BloodDonor.CustomException.NotAcceptableException;
import com.example.BloodDonor.ExceptionBody.CustomExceptionBody;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String QueryTimeoutException(QueryTimeoutException exception){
        return exception.getMessage();
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RedisConnectionFailureException(RedisConnectionFailureException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(value={CustomException.class})
    public ResponseEntity<Object> customExceptionMethod(CustomException e){
        CustomExceptionBody body=new CustomExceptionBody(e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")));
        return  new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {NotAcceptableException.class})
    public ResponseEntity<Object> customNotAcceptableException(NotAcceptableException e){
        CustomExceptionBody body=new CustomExceptionBody(e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE,
                ZonedDateTime.now(ZoneId.of("Z")));
        return  new ResponseEntity<>(body,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<Object> customAlreadyExistsException(AlreadyExistsException e){
        CustomExceptionBody body=new CustomExceptionBody(e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE,
                ZonedDateTime.now(ZoneId.of("Z")));
        return  new ResponseEntity<>(body,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<Object> DataNotFoundedException(DataNotFoundException e){
        CustomExceptionBody body=new CustomExceptionBody(e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")));
        return  new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }


}
