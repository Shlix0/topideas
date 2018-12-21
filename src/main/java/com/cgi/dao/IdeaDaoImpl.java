package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.Idea;
import com.cgi.utils.ContextDB;

public class IdeaDaoImpl implements IdeaDao {

	@Override
	public List<Idea> findAll() {
		EntityManager em = null;
		List<Idea> ideas = null;
		
		try {
			ideas = new ArrayList<Idea>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select i from Idea i");
			ideas = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return ideas;
	}

	@Override
	public Idea findByKey(Long key) {
		EntityManager em = null;
		Idea idea = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			idea = em.find(Idea.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return idea;
	}

	@Override
	public void add(Idea obj) {
		EntityManager em = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			em.persist(obj);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public Idea update(Idea obj) {
		Idea idea = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			idea = em.find(Idea.class, obj.getId());
			
			em.getTransaction().begin();
			if(idea != null) em.merge(obj);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return obj;
	}

	@Override
	public void delete(Idea obj) {
		Idea idea = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			idea = em.find(Idea.class, obj.getId());
			
			em.getTransaction().begin();
			if(idea != null) em.remove(idea) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void deleteByKey(Long key) {
		Idea idea = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			idea = em.find(Idea.class, key);
			
			em.getTransaction().begin();
			if(idea != null) em.remove(idea) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public List<Idea> findAllIdeaByCategory() {
			EntityManager em = null;
			List<Idea> ideas = null;
			
			try {
				ideas = new ArrayList<Idea>();
				em = ContextDB.getInstance().getEmf().createEntityManager();

				Query query = em.createQuery("select i from Idea i");
				ideas = query.getResultList();


			} catch (Exception e) {
				e.printStackTrace();
				if (em.getTransaction() != null) {
					em.getTransaction().rollback();
				}
			}
			return ideas;
		}
	}
