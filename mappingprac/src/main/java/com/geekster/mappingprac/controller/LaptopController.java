package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import com.geekster.mappingprac.service.LaptopService;
import com.geekster.mappingprac.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class LaptopController {

    @Autowired
    LaptopService laptopService;
    @PostMapping("Createlaptop")
    public String  addlaptop(Laptop laptop)
    {
        return laptopService.addlaptop(laptop);

    }
    @GetMapping("Getlaptop/{id}")
    public Laptop getlaptopbyId(String id)
    {
        return laptopService.getlaptopbyid(id);
    }
    @PutMapping("Updatelaptop/{id}")
    public String updatelaptopbyid(String id,Integer price)
    {
        return laptopService.updatebylaptopid(id,price);

    }
    @DeleteMapping("Deletelaptop/{id}")
    public String dltbyid(String id)
    {

        return laptopService.dltbyid(id);
    }

}
