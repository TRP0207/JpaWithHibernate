package com.java.JpaWithHibernate.repo;

import com.java.JpaWithHibernate.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query("select s from Student s where s.name= :name")
//    Student findByName(@Param("name") String name);

    List<Student> findByName(String name);

    @EntityGraph(attributePaths = {"address","courses"})
    Page<Student> findAll(Pageable pageable);
}
