package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Course;
import com.geekster.mappingprac.model.Laptop;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IcourseRepo extends CrudRepository<Course,String> {
    @Query(value = "Select * from Course WHERE course_ID = 'id'" ,nativeQuery = true)
    Course findfirstbyid(String id);

    @Modifying
    @Query(value = "UPDATE Course SET duration ='duration' WHERE course_ID = 'id'" ,nativeQuery = true)

    Laptop updatebyid(String id, String duration);
}
