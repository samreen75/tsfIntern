package com.StudentRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.StudentRecord"})
public class Student {

	public static void main(String[] args) {
		SpringApplication.run(Student.class, args);
	}

}

