package com.java.JpaWithHibernate.mapper;

import com.java.JpaWithHibernate.model.Course;
import com.java.JpaWithHibernate.model.CourseRequestDTO;
import com.java.JpaWithHibernate.model.CourseResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO toDto(Course course);
    List<Course> toEntityList(List<CourseRequestDTO> courseRequestDTOS);
    List<CourseResponseDTO> toDTOList(List<Course> courseList);
}