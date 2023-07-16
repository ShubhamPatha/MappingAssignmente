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
