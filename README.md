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
    public Optional<Student> getstudentbyId(String id)
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

    return "done";
    }




}


```
#### LaptopController
   ```

```
#### CourseController
   ```

```
#### AddressController
   ```

```
#### BookController
   
   ```

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
import org.springframework.data.repository.CrudRepository;

public interface IaddressRepo  extends CrudRepository<Address, String> {
}


```
#### IbookRepo
  ```
package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface IbookRepo extends CrudRepository<Book, String> {
}


```
#### IcourseRepo
  ```
package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface IcourseRepo extends CrudRepository<Course,String> {
}



```
#### IlaptopRep
  ```
package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface IlaptopRep extends CrudRepository<Laptop, String> {
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

    public Optional<Student> getstudentbyid(String id) {
       return istudentRepo.findById(id);
    }

    public String updatebystudid(String id,String phone) {
        istudentRepo.updatebystudid(id,phone);
        return "updated";
    }


}


```
#### LaptopService
  ``` 


```

#### CourseService
  ```

```
#### BookService
  ``` 

```

#### AddressService
  ``` 

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
