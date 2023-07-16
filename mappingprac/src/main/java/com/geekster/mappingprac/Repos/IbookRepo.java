package com.geekster.mappingprac.Repos;

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
