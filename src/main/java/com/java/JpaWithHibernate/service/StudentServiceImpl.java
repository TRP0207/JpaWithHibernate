package com.java.JpaWithHibernate.service;

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


    @Override
    public String saveStudent(StudentRequestDTO studentRequestDTO) throws Exception{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Student student = new Student();
            student.setName(studentRequestDTO.getName());
            student.setMarks(studentRequestDTO.getMarks());
            student.setAddress(convertToAddressEntity(studentRequestDTO.getAddress()));

            List<Course> cours = new ArrayList<>();
            for (Integer courseCode : studentRequestDTO.getCourseCodes()) {
                Course course = courseRepository.findById(courseCode)
                        .orElseThrow(() -> new RuntimeException("Course not found: " + courseCode));
                cours.add(course);
                //course.getStudents().add(student); // bi-directional
            }

            student.setCourses(cours);
            studentRepository.save(student);
            transaction.commit();
            entityManager.close();
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

    @Override
    public void saveAllStudents(List<StudentRequestDTO> studentRequestDTOList) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction =entityManager.getTransaction();
        transaction.begin();
        List<Student> studentList = new ArrayList<>();
        for(StudentRequestDTO studentRequestDTO : studentRequestDTOList){
            Student student = new Student();
            student.setName(studentRequestDTO.getName());
            student.setAddress(convertToAddressEntity(studentRequestDTO.getAddress()));
            student.setMarks(studentRequestDTO.getMarks());
            List<Course> cours = new ArrayList<>();
            for (Integer courseCode : studentRequestDTO.getCourseCodes()) {
                Course course = courseRepository.findById(courseCode)
                        .orElseThrow(() -> new RuntimeException("Course not found: " + courseCode));
                cours.add(course);
                //course.getStudents().add(student); // bi-directional
            }
            student.setCourses(cours);
            studentList.add(student);
            student=null;
        }
        studentRepository.saveAll(studentList);
        transaction.commit();
        entityManager.close();
    }

    public Address convertToAddressEntity(AddressRequestDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setAddLine1(dto.getAddLine1());
        address.setAddLine2(dto.getAddLine2());
        address.setPinCode(dto.getPinCode());
        return address;
    }


}
