package com.java.JpaWithHibernate.mapper;

import com.java.JpaWithHibernate.model.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponseDTO toDto(Address address);
    Address toEntity(AddressRequestDTO addressRequestDTO);
}
