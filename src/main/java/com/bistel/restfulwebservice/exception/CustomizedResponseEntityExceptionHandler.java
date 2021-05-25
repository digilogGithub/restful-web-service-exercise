package com.bistel.restfulwebservice.exception;

import com.bistel.restfulwebservice.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> commonHandleException(Exception ex, WebRequest request) {
        CustomizedResponseEntityException customizedResponseEntityException = new CustomizedResponseEntityException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(customizedResponseEntityException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundExceptionHandler(Exception ex, WebRequest request) {
        CustomizedResponseEntityException customizedResponseEntityException = new CustomizedResponseEntityException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(customizedResponseEntityException, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomizedResponseEntityException customizedResponseEntityException = new CustomizedResponseEntityException(
                new Date(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(customizedResponseEntityException, status);
//        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
