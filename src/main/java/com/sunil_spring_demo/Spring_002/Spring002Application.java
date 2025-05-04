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
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
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

	public void createMultipleStudents(StudentDAO studentDAO){
		//creating student objects
		Student std1 = new Student("shyam", "poudel", "spd@gmail.com");
		Student std2 = new Student("ram", "adhikari", "radk@gmail.com");
		Student std3 = new Student("sita", "tiwari", "sta@gmail.com");

		//saving students
		studentDAO.save(std1);
		studentDAO.save(std2);
		studentDAO.save(std3);
	}
}
