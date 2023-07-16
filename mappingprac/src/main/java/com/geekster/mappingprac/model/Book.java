package com.geekster.mappingprac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    private String book_ID;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}
