package com.fnsystems.prototype.business.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsystems.prototype.persistence.event.EventEntity;
import com.fnsystems.prototype.persistence.event.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public EventEntity save(EventEntity event) {
		return eventRepository.save(event);
	}

	@Override
	public List<EventEntity> getEvents() {
		return (List<EventEntity>) eventRepository.findAll();
	}

	@Override
	public EventEntity getEvent(Long id) {
		return eventRepository.findOne(id);
	}
}
