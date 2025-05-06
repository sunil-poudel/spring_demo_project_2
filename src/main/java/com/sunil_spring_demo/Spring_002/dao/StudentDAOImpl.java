package com.sunil_spring_demo.Spring_002.dao;

import com.sunil_spring_demo.Spring_002.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    //no transactional annotation because we are just reading the data
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        //                                   ^^entity class  ^^primary key
        //if not found, entityManager.find returns null
        return student;
    }
}
