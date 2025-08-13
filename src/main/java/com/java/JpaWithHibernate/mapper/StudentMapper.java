package com.java.JpaWithHibernate.mapper;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentRequestDTO;
import com.java.JpaWithHibernate.model.StudentResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CourseMapperHelper.class, AddressMapper.class})
public interface StudentMapper {

    StudentResponseDTO toDto(Student student);
    List<StudentResponseDTO> toDtoList(List<Student> students);
    Student toEntity(StudentRequestDTO studentRequestDTO);
    List<Student> toEntityList(List<StudentRequestDTO> studentRequestDTOList);
}
