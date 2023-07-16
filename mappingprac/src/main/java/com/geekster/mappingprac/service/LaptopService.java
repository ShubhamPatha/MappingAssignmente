package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IlaptopRep;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Address;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    IlaptopRep ilaptopRep;
    @Autowired
    IstudentRepo istudentRepo;
    public String addlaptop(Laptop laptop) {
        Student student= laptop.getStudent();
        Optional<Student> list=istudentRepo.findById(student.getStud_ID());



        if(list.isEmpty()){
            return "Address cannot be added";
        }

        laptop.setStudent(list.get());


        ilaptopRep.save(laptop);
        return "Added";
    }

    public Laptop getlaptopbyid(String id) {

        return ilaptopRep.findfirstbyid(id);

    }


    public String updatebylaptopid(String id, Integer price) {
    Laptop lap=ilaptopRep.updatebyid(id,price);
    return "updated";
    }

    public String dltbyid(String id) {
        Laptop lap=ilaptopRep.findfirstbyid(id);
        ilaptopRep.delete(lap);
        return "deleted";
    }
}
