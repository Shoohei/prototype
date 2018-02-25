package com.fnsystems.prototype.persistence.event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EventRepositoryImpl implements EventRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EventEntity arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends EventEntity> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<EventEntity> findAll() {
		Query query = em.createQuery("SELECT e FROM EventEntity e");
	    return query.getResultList();
	}

	@Override
	public Iterable<EventEntity> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventEntity findOne(Long id) {
		Query query = em.createQuery("SELECT e FROM EventEntity e WHERE e.id = :id");
		query.setParameter("id", id);
		
	    return (EventEntity) query.getSingleResult();
	}

	@Override
	public <S extends EventEntity> S save(S entity) {
		if (entity.getId() == null) {
			em.persist(entity);
			return entity;
		} else {
			return em.merge(entity);
		}
	}

	@Override
	public <S extends EventEntity> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
