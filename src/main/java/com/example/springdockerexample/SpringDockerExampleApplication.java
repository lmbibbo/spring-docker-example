package com.example.springdockerexample;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.springdockerexample.model.Address;
import com.example.springdockerexample.model.Gender;
import com.example.springdockerexample.model.Student;
import com.example.springdockerexample.repository.StudentRepository;

@SpringBootApplication
public class SpringDockerExampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDockerExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
		StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
				"England",
				"London",
				"NE9"
			);
			String email = "jahmed@gmail.com";
			Student student = new Student (
				"Jamila",
				"Ahmed",
				email,
				Gender.MALE,
				address,
				List.of("Computer Science"),
				BigDecimal.TEN,
				LocalDateTime.now()
			);

			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);

			repository.findStudentByEmail(email)
				.ifPresentOrElse(s -> {
					System.out.println("Alumno Existente");
				}, () -> {
					System.out.println("Insertando Alumno");
					repository.insert(student);
				});
		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Student> students = mongoTemplate.find(query, Student.class);
		
		if (students.size()>1) {
			throw new IllegalStateException("Muchos alumnos con este email:"+ email);
		}

		if (students.isEmpty()) {
			System.out.println("Insertando Alumno");
			repository.insert(student);
		}else {
			System.out.println("Alumno Existente");
		}
	}
}