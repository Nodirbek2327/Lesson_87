package com.example.Controller;

import com.example.dto.StudentBookDto;
import com.example.dto.StudentDto2;
import com.example.enums.StudentBookStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student/book")
public class StudentBookController {
    public static List<StudentBookDto> studentBookDtoList = new LinkedList<>();

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public StudentBookDto create(@RequestBody StudentBookDto studentBookDto){
        studentBookDto.setId(UUID.randomUUID().toString());
        studentBookDto.setCreatedDate(LocalDateTime.now());
        studentBookDto.setStatus(StudentBookStatus.TOOK);
        studentBookDtoList.add(studentBookDto);
        return studentBookDto;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StudentBookDto> all() {
        return studentBookDtoList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentBookDto getById(@PathVariable("id") String id) {
        StudentBookDto studentBookDto =  studentBookDtoList.stream().filter(student -> student.getId().equals(id))
                .findAny().orElse(null);
        return studentBookDto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentBookDto getStudentById(@PathVariable("id") String id) {
        StudentBookDto studentBookDto =  studentBookDtoList.stream().filter(student -> student.getId().equals(id))
                .findAny().orElse(null);
        return studentBookDto;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Boolean put(@PathVariable("id") String id) {
        for (StudentBookDto s : studentBookDtoList) {
            if (s.getId().equals(id)) {
                s.setStatus(StudentBookStatus.RETURNED);
                s.setReturnedDate(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }


}
