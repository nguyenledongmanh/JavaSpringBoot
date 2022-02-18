package com.example.ExceptionJavaSpringBoot.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoleException.class)
    public ResponseEntity<?> RoleExceptionHandler(RoleException roleException) {
        return ResponseEntity.status(406).body(roleException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> UnknownException(Exception e) {
        return ResponseEntity.status(409).body(e.getCause());
    }
}
