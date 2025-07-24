package com.java.JpaWithHibernate.service;

import com.java.JpaWithHibernate.model.Student;
import com.java.JpaWithHibernate.repo.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManagerFactory entityManagerFactory;
    

    @Override
    public String saveStudent(Student student) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            studentRepository.save(student);
            transaction.commit();
            return "Student is Saved...";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
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
}
