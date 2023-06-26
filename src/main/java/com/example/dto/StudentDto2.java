package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class StudentDto2 {
    private String id;
    private String name;
    private String surname;
    private  String phone;
    private LocalDateTime createdDate;
}
