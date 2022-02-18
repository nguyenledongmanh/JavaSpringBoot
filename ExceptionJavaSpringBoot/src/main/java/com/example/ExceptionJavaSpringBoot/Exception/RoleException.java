package com.example.ExceptionJavaSpringBoot.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoleException extends Exception{
    private String code, msg;
}
