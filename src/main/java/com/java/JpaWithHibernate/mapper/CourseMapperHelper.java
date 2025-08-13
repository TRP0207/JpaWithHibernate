package com.java.JpaWithHibernate.mapper;

import com.java.JpaWithHibernate.model.Course;
import com.java.JpaWithHibernate.repo.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CourseMapperHelper {

    private final CourseRepository courseRepository;

    public CourseMapperHelper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> mapCourseCodesToCourses(List<Integer> courseCodes) {
        if (courseCodes == null) return Collections.emptyList();
        return courseRepository.findAllById(courseCodes);
    }
}
