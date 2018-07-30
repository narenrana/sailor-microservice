package com.sailor.demo.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sailor.demo.data.Employee;
import com.sailor.demo.data.EmployeeHistory;
import com.sailor.demo.history.repository.EmployeeHistoryRepository;
import com.sailor.demo.repository.EmployeeRepository;
import com.sailor.demo.stream.EventSource;
import com.sailor.demo.stream.Event;

/**
 * 
 * @author naren
 *
 */
@RestController
@RequestMapping("/manager")
@CrossOrigin
public class EmployeeController {

	private final Log log = LogFactory.getLog(getClass());

	@Resource
	private EmployeeRepository employeeRepository;

	@Resource
	private EmployeeHistoryRepository employeeHistoryRepository;

	@Autowired
	private EventSource employeeSource;

	@GetMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> getEmployes() {
		log.info("getEmployes requested");
		Iterable<Employee> orderList = employeeRepository.findAll();

		return orderList;
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		log.info("addEmployee requested" + employee.toString());
		// Sent payload in stream for CRUD operation
		employeeSource.sendEvent(new Event(employee, Event.EventType.EMPLOYEE_CRUD));
		// Send history data in dynamodb
		employeeHistoryRepository.save(new EmployeeHistory(employee));

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}
