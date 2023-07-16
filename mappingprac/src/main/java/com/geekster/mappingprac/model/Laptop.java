package com.geekster.mappingprac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Laptop {
    @Id
    private String lap_ID;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;
}
