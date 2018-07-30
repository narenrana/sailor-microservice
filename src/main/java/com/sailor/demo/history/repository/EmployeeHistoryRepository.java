
package com.sailor.demo.history.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.sailor.demo.data.EmployeeHistory;

 
/**
 * 
 * @author naren
 *
 */
@EnableScan
public interface EmployeeHistoryRepository extends CrudRepository<EmployeeHistory, String>{
}
