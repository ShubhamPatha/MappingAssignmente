package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Student;
import com.geekster.mappingprac.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("Createstudent")
     public String  addstudent(Student student)
    {
        return studentService.addStudent1(student);

    }
    @GetMapping("Getstudent/{id}")
    public Student getstudentbyId(String id)
    {
        return studentService.getstudentbyid(id);
    }
    @PutMapping("Updatestudent/{id}")
    public String updatestudbyid(String id,String phone)
    {
        return studentService.updatebystudid(id,phone);

    }
    @DeleteMapping("Deletestudent/{id}")
    public String dltbyid(String id)
    {

    return studentService.dltbyid(id);
    }




}
