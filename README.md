# MappingAssignmente




## FRAMEWORK AND LANGUAGE USED
* JAVA 17
* MAVEN
* SPRINGBOOT 3.1.1
* MySql
<!-- Headings -->   
## DATA FLOW

<!-- Code Blocks -->

### CONTROLLER
#### StudentController
   ```
package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Student;
import com.geekster.mappingprac.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("Createstudent")
     public String  addstudent(Student student)
    {
        return studentService.addStudent1(student);

    }
    @GetMapping("Getstudent/{id}")
    public Student getstudentbyId(String id)
    {
        return studentService.getstudentbyid(id);
    }
    @PutMapping("Updatestudent/{id}")
    public String updatestudbyid(String id,String phone)
    {
        return studentService.updatebystudid(id,phone);

    }
    @DeleteMapping("Deletestudent/{id}")
    public String dltbyid(String id)
    {

    return studentService.dltbyid(id);
    }




}


```
#### LaptopController
   ```
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

```
#### CourseController
   ```
package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.model.Course;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.service.CourseService;
import com.geekster.mappingprac.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class CourseController {

    @Autowired
    CourseService courseService;
    @PostMapping("CreateCourse")
    public String  addlaptop(Course course)
    {
        return courseService.addcourse(course);

    }
    @GetMapping("Getcourse/{id}")
    public Course getstudentbyId(String id)
    {
        return courseService.getcoursebyid(id);
    }
    @PutMapping("Updatecourse/{id}")
    public String updatestudbyid(String id,String duration)
    {
        return courseService.updatebycourseid(id,duration);

    }
    @DeleteMapping("Deletecourse/{id}")
    public String dltbyid(String id)
    {

        return courseService.dltbyid(id);
    }
}

```
#### AddressController
   ```
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


```
#### BookController
   
   ```
package com.geekster.mappingprac.controller;

import com.geekster.mappingprac.Repos.IaddressRepo;
import com.geekster.mappingprac.model.Address;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.service.AddressService;
import com.geekster.mappingprac.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("CreateAddress")
    public String  addaddress(Address address)
    {
        return addressService.addaddress(address);

    }
    @GetMapping("GetAddress/{id}")
    public Address getlaptopbyId(String id)
    {
        return addressService.getAddressbyid(id);
    }
    @PutMapping("UpdateAddress/{id}")
    public String updateaddressbyid(String id,Address addr)
    {
        return addressService.updatebyaddressid(id,addr);

    }
    @DeleteMapping("Deletelaptop/{id}")
    public String dltbyid(String id)
    {

        return addressService.dltbyid(id);
    }

}

```


 ### MODEL
  #### Address
  ``` 
package com.geekster.mappingprac.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String addressId;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}


```
  #### Book
  ``` 
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
    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}

```
#### Course
  ```
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
    private String ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> studentList;
}


```
#### Laptop
  ```
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
    private String ID;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;
}


```
#### Student
  ```
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
public class Student {
    @Id
    private String stud_ID;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;

    @OneToOne
    private Address address;
}


```


### Repository 
#### IaddressRepo
  ``` 
package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IaddressRepo  extends CrudRepository<Address, String> {

    @Query(value = "Select * from Address WHERE addressId = 'id'" ,nativeQuery = true)
    Address findfirstbyid(String id);
}


```
#### IbookRepo
  ```package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IbookRepo extends CrudRepository<Book, String> {
    @Query(value = "Select * from Book WHERE book_ID = 'id'" ,nativeQuery = true)
    Book findfirstbyid(String id);

    @Modifying
    @Query(value = "UPDATE Book SET price ='pri' WHERE book_ID = 'id'" ,nativeQuery = true)
    Book updatebyid(String id, String pri);
}


```
#### IcourseRepo
  ```
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




```
#### IlaptopRep
  ```
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



```
#### IstudentRepo
   ```
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

```


### SERVICE
#### StudentService
  ``` 
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



```
#### LaptopService
  ``` 

package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IlaptopRep;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Address;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    IlaptopRep ilaptopRep;
    @Autowired
    IstudentRepo istudentRepo;
    public String addlaptop(Laptop laptop) {
        Student student= laptop.getStudent();
        Optional<Student> list=istudentRepo.findById(student.getStud_ID());



        if(list.isEmpty()){
            return "Address cannot be added";
        }

        laptop.setStudent(list.get());


        ilaptopRep.save(laptop);
        return "Added";
    }

    public Laptop getlaptopbyid(String id) {

        return ilaptopRep.findfirstbyid(id);

    }


    public String updatebylaptopid(String id, Integer price) {
    Laptop lap=ilaptopRep.updatebyid(id,price);
    return "updated";
    }

    public String dltbyid(String id) {
        Laptop lap=ilaptopRep.findfirstbyid(id);
        ilaptopRep.delete(lap);
        return "deleted";
    }
}

```

#### CourseService
  ```
package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IcourseRepo;
import com.geekster.mappingprac.Repos.IlaptopRep;
import com.geekster.mappingprac.Repos.IstudentRepo;
import com.geekster.mappingprac.model.Course;
import com.geekster.mappingprac.model.Laptop;
import com.geekster.mappingprac.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    IstudentRepo istudentRepo;
    @Autowired
    IcourseRepo icourseRepo;

    public String addcourse(Course course) {

        List<Student> student= course.getStudent();



        course.setStudent(student);


        icourseRepo.save(course);
        return "Added";
    }

    public Course getcoursebyid(String id) {

        return icourseRepo.findfirstbyid(id);
    }

    public String updatebycourseid(String id, String duration) {

        Laptop lap=icourseRepo.updatebyid(id,duration);
        return "updated";
    }

    public String dltbyid(String id) {

        Course cour=icourseRepo.findfirstbyid(id);
        icourseRepo.delete(cour);
        return "deleted";
    }
}


```
#### BookService
  ``` 
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

```

#### AddressService
  ``` 
package com.geekster.mappingprac.service;

import com.geekster.mappingprac.Repos.IaddressRepo;
import com.geekster.mappingprac.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IaddressRepo iaddressRepo;
    public String addaddress(Address address) {
        iaddressRepo.save(address);
return "updated";
    }

    public Address getAddressbyid(String id) {
    return  iaddressRepo.findfirstbyid(id);

    }

    public String updatebyaddressid(String id, Address addr) {
      Address adrr= iaddressRepo.findfirstbyid(id);
      iaddressRepo.save(adrr);
      return "updated";

    }

    public String dltbyid(String id) {
        Address adr=iaddressRepo.findfirstbyid(id);
        iaddressRepo.delete(adr);
        return "deleted";

    }
}

```


### MAIN
  ``` 

package com.geekster.mappingprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingpracApplication.class, args);
	}

}



```



 ### Application Properties
  ```
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant
spring.datasource.username=root
spring.datasource.password=Shubham12@
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true


```
 ### POM
  ```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.geekster</groupId>
	<artifactId>Restaurant</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Restaurant</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
		<dependency>
			<groupId>com.sun.mail</groupId>
			<artifactId>javax.mail</artifactId>
			<version>1.6.2</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```
## DATA STRUCTURE USED
* LIST 
* STRING
* LOCAL DATE
* INTEGER
* USER

# PROJECT SUMMARY

## a portal 
that encompasses handling of one-to-one, one-to-many, many-to-one, and many-to-many relationships along with the embedded model specified below. 
Additionally, you are required to write CRUD (Create, Read, Update, Delete) operations for each model








<!-- Headings -->   
# Author
SHUBHAM PATHAK
 <!-- UL -->
* Twitter <!-- Links -->
[@ShubhamPathak]( https://twitter.com/Shubham15022000)
* Github  <!-- Links -->
[@ShubhamPathak]( https://github.com/ShubhamPatha)
<!-- Headings -->   
