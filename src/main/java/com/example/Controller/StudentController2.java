package com.example.Controller;

import com.example.dto.StudentDTO;
import com.example.dto.StudentDto2;
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
public class StudentController2 {

    public static List<StudentDto2> studentDto2List = new LinkedList<>();

    @RequestMapping(value = "/student2/create", method = RequestMethod.POST)
    public StudentDto2 create(@RequestBody StudentDto2 student){
        student.setId(UUID.randomUUID().toString());
        student.setCreatedDate(LocalDateTime.now());
        studentDto2List.add(student);
        return student;
    }

    @RequestMapping(value = "/student2/all", method = RequestMethod.GET)
    public List<StudentDto2> all() {
        return studentDto2List;
    }

    @RequestMapping(value = "/student2/{id}", method = RequestMethod.GET)
    public StudentDto2 getById(@PathVariable("id") String id) {
        StudentDto2 studentDto2 =  studentDto2List.stream().filter(student -> student.getId().equals(id))
                .findAny().orElse(null);
        return studentDto2;
    }

    @RequestMapping(value = "/student2/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") String id) {
        boolean result = studentDto2List.removeIf(s -> s.getId().equals(id));
        return result;
    }

    @RequestMapping(value = "/student2/{id}", method = RequestMethod.PUT)
    public Boolean put(@RequestBody StudentDto2 student,
                       @PathVariable("id") String id) {
        for (StudentDto2 s : studentDto2List) {
            if (s.getId().equals(id)) {
                s.setPhone(student.getPhone());
                s.setName(student.getName());
                s.setSurname(student.getSurname());
                return true;
            }
        }
        return false;
    }

}
