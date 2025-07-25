package com.java.JpaWithHibernate.controller;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name){
        List<Student> students = studentService.findUserByName(name);
        if (students != null) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        try{
            List<Student> studentList = studentService.getAllStudents();
            if (studentList != null) {
                return new ResponseEntity<>(studentList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }

    }
}
