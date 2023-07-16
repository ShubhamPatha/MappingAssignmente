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
