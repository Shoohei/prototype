package com.fnsystems.prototype.persistence.event;

import org.springframework.data.repository.CrudRepository;

/**
 * Persistence service for events
 */
public interface EventRepository extends CrudRepository<EventEntity, Long> {
	
}
