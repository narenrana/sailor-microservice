
package com.sailor.demo.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sailor.demo.data.Employee;
/**
 * 
 * @author naren
 *
 */
@Primary
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
