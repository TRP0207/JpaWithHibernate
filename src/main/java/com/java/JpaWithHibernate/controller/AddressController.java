package com.java.JpaWithHibernate.controller;

import com.java.JpaWithHibernate.model.Address;
import com.java.JpaWithHibernate.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<String> saveAddress(@RequestBody Address address){
        try {
            return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Address>> getAllAddresses(){
        try{
            List<Address> addressList = addressService.getAllAddresses();
            if (addressList != null) {
                return new ResponseEntity<>(addressList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable  int id){
        try{
            addressService.deleteAddress(id);
            return new ResponseEntity<>("Address Deleted", HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }
}
