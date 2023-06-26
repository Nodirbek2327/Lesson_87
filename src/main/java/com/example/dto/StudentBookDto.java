package com.example.dto;

import com.example.enums.StudentBookStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class StudentBookDto {
    private String id;
    private String student_id;
    private String book_id;
    private LocalDateTime createdDate;
    private StudentBookStatus Status;
    private LocalDateTime returnedDate;
    private long duration;

}

