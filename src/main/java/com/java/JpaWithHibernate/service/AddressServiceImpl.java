package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Address;
import com.java.JpaWithHibernate.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;


    @Override
    public String saveAddress(Address address) {
        addressRepository.save(address);
        return "Address is Saved Successfully...";
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
