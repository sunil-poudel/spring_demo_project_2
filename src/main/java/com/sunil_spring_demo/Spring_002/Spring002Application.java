package com.sunil_spring_demo.Spring_002;

import com.sunil_spring_demo.Spring_002.dao.StudentDAO;
import com.sunil_spring_demo.Spring_002.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			readStudent(studentDAO, 1);
//			readStudent(studentDAO, 2);
//			readStudent(studentDAO, 3);

			//call to display all students
//			queryStudents(studentDAO);

//			findByLastName(studentDAO);

//			updateStudent(studentDAO, 3);

//			updateAllStudents(studentDAO);

//			deleteStudent(studentDAO,2);

//			deleteConditional(studentDAO);
		};
	}

	public void createStudent(StudentDAO studentDAO){
		//create new Student
		System.out.println("Creating student object...");
		Student student = new Student("Rishiram", "Poudel", "rshrmpdl@gmail.com");

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

	public void readStudent(StudentDAO studentDAO, int id){
		Student student = studentDAO.findById(id);
		System.out.println(student);
	}

	public void queryStudents(StudentDAO studentDAO) {
		List<Student> studentsList = studentDAO.findAll();
		for(Student student:studentsList){
			System.out.println(student);
		}
	}

	public void findByLastName(StudentDAO studentDAO){
		List<Student> studentsList = studentDAO.findByLastName("Adhikari");
		for(Student student:studentsList){
			System.out.println(student);
		}
	}

	public void updateStudent(StudentDAO studentDAO, int id){
		//get student
		Student student = studentDAO.findById(id);

		//update student
		student.setFirstName("Hello");
		student.setLastName("World");
		student.setEmail("hlwd@gmail.com");

		studentDAO.update(student);

		//display message
		System.out.println("Updated: \n"+student);

	}

	public void updateAllStudents(StudentDAO studentDAO){
		System.out.println("updating: ");

		int n = studentDAO.updateAll();

		System.out.println("Updated successfully! "+n+" row(s)!!");

		queryStudents(studentDAO);
	}

	public void deleteStudent(StudentDAO studentDAO, int id){
		System.out.println("deleting: ");
		readStudent(studentDAO, id);

		//delete
		studentDAO.delete(id);

		System.out.println("Deleted successfully!");
	}

	public void deleteConditional(StudentDAO studentDAO){
		int n = studentDAO.conditionalDelete();

		System.out.println("deleted "+n+" row(s)");
	}


}
