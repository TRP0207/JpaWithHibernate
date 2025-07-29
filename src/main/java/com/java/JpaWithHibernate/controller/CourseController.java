package com.java.JpaWithHibernate.controller;

import com.java.JpaWithHibernate.model.Courses;
import com.java.JpaWithHibernate.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CoursesService coursesService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Courses courses){
        try {
            return new ResponseEntity<>(coursesService.saveCourse(courses), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Courses>> getCourse(){
        try{
            List<Courses> courseList = coursesService.getAllCourse();
            if (courseList != null) {
                return new ResponseEntity<>(courseList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable  int id){
        try{
            coursesService.deleteCourse(id);
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
