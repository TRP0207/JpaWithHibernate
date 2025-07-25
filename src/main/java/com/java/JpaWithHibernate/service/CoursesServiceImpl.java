package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Courses;
import com.java.JpaWithHibernate.repo.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{

    @Autowired
    CoursesRepository coursesRepository;

    @Override
    public String saveCourse(Courses courses) {
        coursesRepository.save(courses);
        return "Course saved Successfully...";
    }

    @Override
    public List<Courses> getAllCourse() {
        return coursesRepository.findAll();
    }
}
