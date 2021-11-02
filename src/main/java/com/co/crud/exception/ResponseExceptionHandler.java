package com.co.crud.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        String errores = "";
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores += error.getField() + ": " + error.getDefaultMessage();
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errores += error.getObjectName() + ": " + error.getDefaultMessage();
        }

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), "Validacion fallida", errores);
        return handleExceptionInternal(
                ex, exceptionResponse, headers, HttpStatus.BAD_REQUEST, request);
    }
}
