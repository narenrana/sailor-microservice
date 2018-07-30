 

package com.sailor.demo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.sailor.demo.history.repository.EmployeeHistoryRepository;
import com.sailor.demo.repository.EmployeeRepository;

/**
 *
 * @author naren
 *
 */
@SpringBootApplication
@EnableDynamoDBRepositories(basePackageClasses = EmployeeHistoryRepository.class)//TODO use base package or equivalent property
@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)//TODO use base package or equivalent property
public class SailorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SailorApplication.class, args);
	}
	

}
