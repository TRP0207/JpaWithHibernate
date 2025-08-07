package com.java.JpaWithHibernate.controller;

import com.java.JpaWithHibernate.model.Course;
import com.java.JpaWithHibernate.model.CourseRequestDTO;
import com.java.JpaWithHibernate.model.CourseResponseDTO;
import com.java.JpaWithHibernate.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        try {
            return new ResponseEntity<>(courseService.saveCourse(courseRequestDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseResponseDTO>> getCourse(){
        try{
            List<CourseResponseDTO> courseList = courseService.getAllCourse();
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
            courseService.deleteCourse(id);
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addAll")
    public ResponseEntity<String> addAllCourses(@RequestBody List<CourseRequestDTO> courseRequestDTOList){
        try{
            courseService.saveAllCourses(courseRequestDTOList);
            return new ResponseEntity<>("Courses Added...", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
