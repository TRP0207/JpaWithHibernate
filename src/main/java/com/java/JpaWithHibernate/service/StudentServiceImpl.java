package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Courses;
import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.model.StudentDTO;
import com.java.JpaWithHibernate.repo.CoursesRepository;
import com.java.JpaWithHibernate.repo.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;
    

    @Override
    public String saveStudent(StudentDTO studentDTO) throws Exception{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Student student = new Student();
            student.setName(studentDTO.getName());
            student.setMarks(studentDTO.getMarks());
            student.setAddress(studentDTO.getAddress());

            List<Courses> courses = new ArrayList<>();
            for (Integer courseCode : studentDTO.getCourseCodes()) {
                Courses course = coursesRepository.findById(courseCode)
                        .orElseThrow(() -> new RuntimeException("Course not found: " + courseCode));
                courses.add(course);
                //course.getStudents().add(student); // bi-directional
            }

            student.setCourses(courses);
            studentRepository.save(student);
            transaction.commit();
            return "Student is Saved...";
    }

    @Override
    public List<Student> findUserByName(String name){
        List<Student> students;
        try {
            students = studentRepository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
