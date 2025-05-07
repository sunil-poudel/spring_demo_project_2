package com.sunil_spring_demo.Spring_002.dao;

import com.sunil_spring_demo.Spring_002.entity.Student;

import java.util.List;

public interface StudentDAO {
    //saving student
    void save(Student student);

    //finding student by id
    Student findById(int id);

    //finding list of students
    List<Student> findAll();

    //find by last name
    List<Student> findByLastName(String lastName);
}
