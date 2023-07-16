package com.geekster.mappingprac.Repos;

import com.geekster.mappingprac.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IaddressRepo  extends CrudRepository<Address, String> {

    @Query(value = "Select * from Address WHERE addressId = 'id'" ,nativeQuery = true)
    Address findfirstbyid(String id);
}
