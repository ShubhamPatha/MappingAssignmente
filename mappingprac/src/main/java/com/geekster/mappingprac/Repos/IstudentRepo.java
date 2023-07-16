package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IstudentRepo extends CrudRepository<Student,String> {

    @Modifying
    @Query(value = "UPDATE Student SET phoneNumber ='phone' WHERE stud_ID = 'id'" ,nativeQuery = true)
    void updatebystudid(String id, String phone);


    @Query(value = "Select * from Student WHERE stud_ID = 'id'" ,nativeQuery = true)
    Student findfirtstbyid(String id);
}
