package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.mapper.AddressMapper;
import com.java.JpaWithHibernate.mapper.StudentMapper;
import com.java.JpaWithHibernate.model.*;
import com.java.JpaWithHibernate.repo.CourseRepository;
import com.java.JpaWithHibernate.repo.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public String saveStudent(StudentRequestDTO studentRequestDTO) throws Exception{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            studentRepository.save(studentMapper.toEntity(studentRequestDTO));
            /*Student student = new Student();
            student.setName(studentRequestDTO.getName());
            student.setMarks(studentRequestDTO.getMarks());
            student.setAddress(addressMapper.toEntity(studentRequestDTO.getAddress()));
            List<Course> courses = new ArrayList<>();
            for (Integer courseCode : studentRequestDTO.getCourses()) {
                Course course = courseRepository.findById(courseCode)
                        .orElseThrow(() -> new RuntimeException("Course not found: " + courseCode));
                courses.add(course);
                //course.getStudents().add(student); // bi-directional
            }

            student.setCourses(courses);
            studentRepository.save(student);*/
            transaction.commit();
            entityManager.close();
            return "Student is Saved...";
    }

    @Override
    public List<StudentResponseDTO> findUserByName(String name){
        List<StudentResponseDTO> students;
        try {
            List<Student> studentsList = studentRepository.findByName(name);
            students = studentMapper.toDtoList(studentsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void saveAllStudents(List<StudentRequestDTO> studentRequestDTOList) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();

        studentRepository.saveAll(studentMapper.toEntityList(studentRequestDTOList));
        /*List<Student> studentList = new ArrayList<>();
        for(StudentRequestDTO studentRequestDTO : studentRequestDTOList){
            Student student = new Student();
            student.setName(studentRequestDTO.getName());
            student.setAddress(addressMapper.toEntity(studentRequestDTO.getAddress()));
            student.setMarks(studentRequestDTO.getMarks());
            List<Course> courseList = new ArrayList<>();
            for (Integer courseCode : studentRequestDTO.getCourses()) {
                Course course = courseRepository.findById(courseCode)
                        .orElseThrow(() -> new RuntimeException("Course not found: " + courseCode));
                courseList.add(course);
                //course.getStudents().add(student); // bi-directional
            }
            student.setCourses(courseList);
            studentList.add(student);
            student=null;
        }
        studentRepository.saveAll(studentList);*/
        transaction.commit();
        entityManager.close();
    }


}
