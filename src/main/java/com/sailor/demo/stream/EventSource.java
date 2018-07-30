
package com.sailor.demo.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;


/**
 * 
 * @author naren
 *
 */
@Component
public class EventSource {

	private final Log log = LogFactory.getLog(getClass());

	private EventProcessor eventProcessor;

	@Autowired
	public EventSource(EventProcessor eventProcessor) {
		this.eventProcessor = eventProcessor;
	}

	public void sendEvent(Event event) {
		eventProcessor.ordersOut().send(new GenericMessage<>(event));
		log.info("Event sent: " + event.toString());
	}

}
