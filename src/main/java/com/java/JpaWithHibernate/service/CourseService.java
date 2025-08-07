package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Course;
import com.java.JpaWithHibernate.model.CourseRequestDTO;
import com.java.JpaWithHibernate.model.CourseResponseDTO;

import java.util.List;

public interface CourseService {
    public String saveCourse(CourseRequestDTO course);
    public List<CourseResponseDTO> getAllCourse();
    public void deleteCourse(int id);
    public void saveAllCourses(List<CourseRequestDTO> courseRequestDTOList);
}
