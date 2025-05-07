package com.sunil_spring_demo.Spring_002.dao;

import com.sunil_spring_demo.Spring_002.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        //display all students
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        //Students whose last name is Poudel
        //Note that Student and lastName are entity class and fields.
//        TypedQuery<Student> query = entityManager.createQuery(
//                "FROM Student WHERE lastName='Poudel'"
//                ,Student.class
//        );

        //students whose email ends at @gmail.com
//        TypedQuery<Student> query = entityManager.createQuery(
//                "FROM Student WHERE email LIKE '%@gmail.com'"
//                ,Student.class
//        );

        //strictly using JPQL (with Select clause)
//        TypedQuery<Student> query = entityManager.createQuery(
//                "SELECT s FROM Student s where s.lastName=:theLastName"
//                ,Student.class
//        );
//        String lastName = "Poudel";
//        query.setParameter("theLastName", lastName);
        return query.getResultList();
    }

}
