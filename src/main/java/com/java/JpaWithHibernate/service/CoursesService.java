package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Courses;

import java.util.List;

public interface CoursesService {
    public String saveCourse(Courses courses);
    public List<Courses> getAllCourse();
    public void deleteCourse(int id);
}
