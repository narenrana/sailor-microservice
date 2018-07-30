
package com.sailor.demo.data;

import java.util.UUID;

import org.springframework.data.annotation.Id;
 
/**
 * 
 * @author naren
 *
 */
public class Employee {

 
	@Id
	private String id;
	 
	private String firstName;
	 
	private String lastName;
	 
	private Long managerId;
	 
	private String message;


	public Employee() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="+", managerId=" + managerId + ", message=" + message + "]";
	}
 

}
