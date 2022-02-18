package com.example.ExceptionJavaSpringBoot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String id, name;
    private List<String> roleList;
}
