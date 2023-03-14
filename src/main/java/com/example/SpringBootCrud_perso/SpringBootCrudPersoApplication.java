package com.example.SpringBootCrud_perso;

import com.example.SpringBootCrud_perso.Domain.Students;
import com.example.SpringBootCrud_perso.Service.StudentService;
// import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootCrudPersoApplication {
	public static StudentService studentService;
	public static void main(String[] args) {

		// SpringApplication.run(SpringBootCrudPersoApplication.class, args); CE QUI EST PRESENT DE BASE
		ApplicationContext context = SpringApplication.run(SpringBootCrudPersoApplication.class, args); // pourquoi ça ?
		studentService = context.getBean(StudentService.class); // ??
		while (true) {
			start();
		}
	}

	public static void start(){ // String... args ?????
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an operation: ");
		String input = scanner.nextLine();
		System.out.println("You entered: " + input);

		switch (input) { // modifié
			case "c" :
				create();
				break;
			case "r" :
				read();
				break;
			case "u" :
				update();
				break;
			case "d" :
				delete();
				break;
		}
	}

	public static void create () {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Student Name, Course, Fee: ");
		String[] input = scanner.nextLine().split(" ");

		Students students = new Students(studentService.generateNewId(), input[0], input[1], Integer.parseInt(input[2]));
		studentService.save(students); // sinon le nouveau students créé sera supprimé ??
	}

	public static void read () {
		System.out.println(studentService.findAll());

		/*
		Equivalent à
			List<Students> allStudents = studentService.findAll();
			System.out.println(allStudents);
		?????
		*/
	}

	public static void update () {
		Scanner scanner4 = new Scanner(System.in);
		System.out.print("Enter the id you want to update : ");
		Long input4 = scanner4.nextLong();

		System.out.print(studentService.findById(input4) + " updating in : ");
		Scanner scanner44 = new Scanner(System.in);
		String[] input44 = scanner44.nextLine().split(" ");

		Students student = studentService.findById(input4); // le student est sauvegardé dans la db mais pas dans IntelliJ
															// il faut donc le récupérer et créer une instance qu'on pourra
															// alors modifier puis sauvegarder
		student.setStudentName(input44[0]);
		student.setCourse(input44[1]);
		student.setFee(Integer.parseInt(input44[2]));
		studentService.save(student);

		/*
			studentService.findById(input4).setStudentName(input44[1]);
			studentService.findById(input4).setCourse(input44[2]);
			studentService.findById(input4).setFee(Integer.parseInt(input44[3]));
			System.out.println("The id has been updated in : " + studentService.findById(input4));
		tout seul --> pas bon */

		/*
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("Enter the id you want to update: ");
			Long input = scanner1.nextLong();
			Students student = studentService.findById(input);
			System.out.print(student);
			create();
		 avec Rida */
	}

	public static void delete () {
		System.out.println(studentService.findAll());
		System.out.print("Enter the id you want to delete : ");
		Scanner scanner3 = new Scanner(System.in);
		Long input7 = scanner3.nextLong();

		studentService.delete(input7);
		System.out.println(studentService.findAll());
	}

}
// public Students findById (Long id) {return repo.findById(id).orElse(null);}