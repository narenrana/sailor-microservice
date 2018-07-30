package com.sailor.demo.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.sailor.demo.repository.EmployeeRepository;

/**
 * 
 * @author naren
 *
 */
@EnableBinding(EventProcessor.class)
public class EventStreamConfiguration {

	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	private EmployeeRepository employeeRepository;

	@StreamListener(EventProcessor.INPUT)
	public void processOrder(Event event) {
		if (event.getPayload() !=null) {
			employeeRepository.save(event.getPayload());
			log.info("Event received " + event.toString());
		}
		else {
			log.info("Empty event received " + event.toString());
		}
	}

}
