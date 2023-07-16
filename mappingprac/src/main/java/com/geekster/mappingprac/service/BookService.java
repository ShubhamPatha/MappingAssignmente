package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IbookRepo;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Book;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BookService {
    @Autowired
    IbookRepo ibookRepo;
            @Autowired
    IstudentRepo istudentRepo;
    public String addbook(Book book) {
        Student student= book.getStudent();
        Optional<Student> list=istudentRepo.findById(student.getStud_ID());



        if(list.isEmpty()){
            return "Address cannot be added";
        }

        book.setStudent(list.get());


        ibookRepo.save(book);
        return "Added";
    }

    public Book getbookbyid(String id) {
        return ibookRepo.findfirstbyid(id);
    }

    public String updatebybookid(String id, String pri) {
        Book book=ibookRepo.updatebyid(id,pri);
        return "updated";
    }

    public String dltbyid(String id) {
        Book book=ibookRepo.findfirstbyid(id);
        ibookRepo.delete(book);
        return "deleted";
    }
}
