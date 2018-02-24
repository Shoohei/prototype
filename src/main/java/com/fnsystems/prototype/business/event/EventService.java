package com.fnsystems.prototype.business.event;

import java.util.List;

import com.fnsystems.prototype.persistence.event.EventEntity;

/**
 * Business service for events
 */
public interface EventService {
	
	/**
	 * Save the event
	 * @param event The event to save
	 * @return The event saved
	 */
	public EventEntity save(EventEntity event);

	/**
	 * Return all the events
	 * @return The events
	 */
	public List<EventEntity> getEvents();
}
