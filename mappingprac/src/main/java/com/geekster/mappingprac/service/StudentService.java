package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IaddressRepo;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Address;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IstudentRepo istudentRepo;
    @Autowired
    IaddressRepo iaddressRepo;

    public String addStudent1(Student student) {

         Address address = student.getAddress();

        Optional<Address> list = iaddressRepo.findById(address.getAddressId());

        if(list.isEmpty()){
            return "Address cannot be added";
        }

        student.setAddress(list.get());

        istudentRepo.save(student);


        return "Address added successfully";
    }

    public Student getstudentbyid(String id) {


        Student stu= istudentRepo.findfirtstbyid(id);
        return  stu;

    }

    public String updatebystudid(String id,String phone) {
        istudentRepo.updatebystudid(id,phone);
        return "updated";
    }


    public String dltbyid(String id) {
    Student stu= istudentRepo.findfirtstbyid(id);
if(stu==null)
{

    return "Item not found";
}else {

    istudentRepo.delete(stu);
    return "Item deleted";

}

    }
}
