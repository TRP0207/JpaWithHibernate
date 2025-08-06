package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Course;
import com.java.JpaWithHibernate.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public String saveCourse(Course course) {
        courseRepository.save(course);
        return "Course saved Successfully...";
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void saveAllCourses(List<Course> courseList) {
        courseRepository.saveAll(courseList);
    }
}
