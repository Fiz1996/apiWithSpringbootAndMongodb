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





}
