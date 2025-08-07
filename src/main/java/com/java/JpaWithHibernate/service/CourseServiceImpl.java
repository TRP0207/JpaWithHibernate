package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.mapper.CourseMapper;
import com.java.JpaWithHibernate.model.*;
import com.java.JpaWithHibernate.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public String saveCourse(CourseRequestDTO courseRequestDTO) {
        Course course = courseMapper.toEntity(courseRequestDTO);
        courseRepository.save(course);
        return "Course saved Successfully...";
    }

    @Override
    public List<CourseResponseDTO> getAllCourse() {
        return courseMapper.toDTOList(courseRepository.findAll());
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void saveAllCourses(List<CourseRequestDTO> courseRequestDTOList) {
        courseRepository.saveAll(courseMapper.toEntityList(courseRequestDTOList));
    }
}
