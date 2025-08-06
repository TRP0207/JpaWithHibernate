package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Course;

import java.util.List;

public interface CourseService {
    public String saveCourse(Course course);
    public List<Course> getAllCourse();
    public void deleteCourse(int id);
    public void saveAllCourses(List<Course> courseList);
}
