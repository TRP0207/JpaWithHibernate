package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Address;

import java.util.List;

public interface AddressService {
    public String saveAddress(Address address);
    public List<Address> getAllAddresses();
}
