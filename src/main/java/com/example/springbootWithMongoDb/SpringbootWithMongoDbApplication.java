package com.example.springbootWithMongoDb;

import com.example.springbootWithMongoDb.entity.Address;
import com.example.springbootWithMongoDb.entity.Gender;
import com.example.springbootWithMongoDb.entity.Student;
import com.example.springbootWithMongoDb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringbootWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithMongoDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address(
					"England",
					 "London",
					"NE9"

			);

			String email = "fadsfsa@email.com";
			Student student = new Student(
					"Ahmad",
					"test",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science","Maths"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);


		//	usingMongoDbTemplate(repository, mongoTemplate, email, student);
			repository.findStudentByEmail(email)
			.ifPresentOrElse(student1 -> {
				System.out.println(student + "already exists");

			},()-> {			System.out.println("Inserting student"+ student);
				repository.insert(student);});

		};
	}

	private void usingMongoDbTemplate(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students= mongoTemplate.find(query,Student.class);
		if(students.size() >1){
			throw new IllegalArgumentException("found many students with email "+ email);
		}
		if(students.isEmpty()){
			System.out.println("Inserting student"+ student);
			repository.insert(student);
		}
		else {
			System.out.println(student + "already exists");
		}
	}

}
