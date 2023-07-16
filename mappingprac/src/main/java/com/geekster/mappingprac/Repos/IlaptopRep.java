package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Laptop;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IlaptopRep extends CrudRepository<Laptop, String> {
    @Query(value = "Select * from Laptop WHERE lap_ID = 'id'" ,nativeQuery = true)
    Laptop findfirstbyid(String id);


    @Modifying
    @Query(value = "UPDATE Laptop SET price ='price' WHERE lap_ID = 'id'" ,nativeQuery = true)
    Laptop updatebyid(String id, Integer price);
}
