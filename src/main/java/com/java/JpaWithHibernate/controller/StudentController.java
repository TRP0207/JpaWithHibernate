package com.java.JpaWithHibernate.controller;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentRequestDTO;
import com.java.JpaWithHibernate.model.StudentResponseDTO;
import com.java.JpaWithHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDTO student){
        try{
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByName(@PathVariable String name){
        List<StudentResponseDTO> students = studentService.findUserByName(name);
        try{
            if (students != null) {
                return new ResponseEntity<>(students, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        try{
            List<StudentResponseDTO> studentList = studentService.getAllStudents();
            if (studentList != null) {
                return new ResponseEntity<>(studentList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        try{
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @PostMapping("/addAll")
    public ResponseEntity<String> addAllStudent(@RequestBody List<StudentRequestDTO> students){
        try{
            studentService.saveAllStudents(students);
            return new ResponseEntity<>("Students Added...", HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<StudentResponseDTO>> getPaginatedStudentList(@RequestParam(defaultValue = "0") int page,
                                                                            @RequestParam(defaultValue = "5") int size,
                                                                            @RequestParam(defaultValue = "id") String sortBy) {
        try {
            return new ResponseEntity<>(studentService.getPaginatedStudentList(page, size, sortBy), HttpStatus.OK);
        } catch (Exception e) {
                throw new RuntimeException("Error occurred..." + e.getMessage());
        }
    }
}
