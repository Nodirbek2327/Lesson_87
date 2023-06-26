package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String publishYear;
}
