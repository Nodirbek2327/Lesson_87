package com.example.service;

import com.example.dto.StudentDTO;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    public static List<StudentDTO> studentList = new LinkedList<>();

    public StudentService() {
        StudentDTO dto = new StudentDTO();
        dto.setId("12345");
        dto.setName("Toshmat");
        dto.setSurname("Toshmatov");
        studentList.add(dto);
    }

    public StudentDTO add(StudentDTO student) {
        check(student); // validate inputs
        student.setId(UUID.randomUUID().toString());
        studentList.add(student);
        return student;
    }

    public List<StudentDTO> addAll(List<StudentDTO> list) {
        for (StudentDTO dto : list) {
            check(dto);
            dto.setId(UUID.randomUUID().toString());
            studentList.add(dto);
        }
        return list;
    }

    public List<StudentDTO> getAll() {
        return studentList;
    }

    public StudentDTO getById(String id) {
        StudentDTO studentDTO = studentList.stream()
                .filter(student -> student.getId().equals(id))
                .findAny()
                .orElseThrow(() -> {
                    throw new ItemNotFoundException("Student NOt Found");
                });
        return studentDTO;
    }

    public Boolean delete(String id) {
        boolean result = studentList.removeIf(s -> s.getId().equals(id));
        return result;
    }

    public Boolean update(String id, StudentDTO student) {
        check(student);
        for (StudentDTO s : studentList) {
            if (s.getId().equals(id)) {
                s.setName(student.getName());
                s.setSurname(student.getSurname());
                return true;
            }
        }
        throw new ItemNotFoundException("Student not found");
    }

    private void check(StudentDTO student) {
        if (student.getName() == null || student.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (student.getSurname() == null || student.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
    }
}
