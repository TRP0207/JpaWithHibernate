package com.java.JpaWithHibernate.mapper;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentRequestDTO;
import com.java.JpaWithHibernate.model.StudentResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO toDto(Student student);
    List<StudentResponseDTO> toDtoList(List<Student> students);
}
