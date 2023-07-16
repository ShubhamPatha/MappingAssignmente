package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Book;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.service.BookService;
import com.geekster.mappingprac.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("Createbook")
    public String  addbook(Book book)
    {
        return bookService.addbook(book);

    }
    @GetMapping("Getbook/{id}")
    public Book getlbookbyId(String id)
    {
        return bookService.getbookbyid(id);
    }
    @PutMapping("Updatebok/{id}")
    public String updatebookbyid(String id,String  pri)
    {
        return bookService.updatebybookid(id,pri);

    }
    @DeleteMapping("Deletebook/{id}")
    public String dltbyid(String id)
    {

        return bookService.dltbyid(id);
    }

}
