package com.fnsystems.prototype.business.event;

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
}
