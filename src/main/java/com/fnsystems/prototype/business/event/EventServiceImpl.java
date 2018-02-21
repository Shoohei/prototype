package com.fnsystems.prototype.business.event;

import org.springframework.beans.factory.annotation.Autowired;

import com.fnsystems.prototype.persistence.event.EventEntity;
import com.fnsystems.prototype.persistence.event.EventRepository;

public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public EventEntity save(EventEntity event) {
		return eventRepository.save(event);
	}
}
