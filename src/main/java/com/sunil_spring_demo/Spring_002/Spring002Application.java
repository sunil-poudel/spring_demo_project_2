package com.sunil_spring_demo.Spring_002;

import com.sunil_spring_demo.Spring_002.dao.StudentDAO;
import com.sunil_spring_demo.Spring_002.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring002Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring002Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	public void createStudent(StudentDAO studentDAO){
		//create new Student
		System.out.println("Creating student object...");
		Student student = new Student("Rishiram", "Poudel", "rshrmpdl@gmail.com");

		//save
		System.out.println("Saving student...");
		studentDAO.save(student);

		//display id
		System.out.println("Saved successfully! Generated id: "+student.getId());



	}
}
