
package com.sailor.demo.stream;
import java.util.UUID;

import com.sailor.demo.data.Employee;
/**
 * 
 * @author naren
 *
 */

public class Event {
   public static  enum EventType { EMPLOYEE_CRUD}
	private UUID id;

	private Employee payload;

	private EventType type;

	
	
	public Event(Employee payload, EventType type) {
		this.payload = payload;
		this.type = type;
	}
	
	public Event() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Employee getPayload() {
		return payload;
	}

	public void setPayload(Employee payload) {
		this.payload = payload;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", payload=" + payload + ", type=" + type + "]";
	}

	

}
