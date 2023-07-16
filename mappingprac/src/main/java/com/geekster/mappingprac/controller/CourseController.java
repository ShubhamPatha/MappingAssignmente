package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Course;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.service.CourseService;
import com.geekster.mappingprac.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class CourseController {

    @Autowired
    CourseService courseService;
    @PostMapping("CreateCourse")
    public String  addlaptop(Course course)
    {
        return courseService.addcourse(course);

    }
    @GetMapping("Getcourse/{id}")
    public Course getstudentbyId(String id)
    {
        return courseService.getcoursebyid(id);
    }
    @PutMapping("Updatecourse/{id}")
    public String updatestudbyid(String id,String duration)
    {
        return courseService.updatebycourseid(id,duration);

    }
    @DeleteMapping("Deletecourse/{id}")
    public String dltbyid(String id)
    {

        return courseService.dltbyid(id);
    }
}
