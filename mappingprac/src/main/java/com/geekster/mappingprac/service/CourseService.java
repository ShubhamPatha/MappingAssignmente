package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IcourseRepo;
import com.geekster.mappingprac.Repos.IlaptopRep;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Course;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    IstudentRepo istudentRepo;
    @Autowired
    IcourseRepo icourseRepo;

    public String addcourse(Course course) {

        List<Student> student= course.getStudent();



        course.setStudent(student);


        icourseRepo.save(course);
        return "Added";
    }

    public Course getcoursebyid(String id) {

        return icourseRepo.findfirstbyid(id);
    }

    public String updatebycourseid(String id, String duration) {

        Laptop lap=icourseRepo.updatebyid(id,duration);
        return "updated";
    }

    public String dltbyid(String id) {

        Course cour=icourseRepo.findfirstbyid(id);
        icourseRepo.delete(cour);
        return "deleted";
    }
}
