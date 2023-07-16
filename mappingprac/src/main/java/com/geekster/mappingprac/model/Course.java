package com.geekster.mappingprac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {
    @Id
    private String course_ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> student;
}
