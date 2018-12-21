package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.User;
import com.cgi.utils.ContextDB;

public class LoginDaoImpl implements UserDao {

	@Override
	public List<User> findAll() {
		EntityManager em = null;
		List<User> users = null;
		
		try {
			users = new ArrayList<User>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select u from User u");
			users = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return users;
	}

	@Override
	public User findByKey(Integer key) {
		EntityManager em = null;
		User user = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			user = em.find(User.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return user;
	}

	@Override
	public void add(User obj) {
		User user = null;
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
	public User update(User obj) {
		User user = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			user = em.find(User.class, obj.getId());
			
			em.getTransaction().begin();
			if(user != null) em.merge(obj);
			
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
	public void delete(User obj) {
		User user = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			user = em.find(User.class, obj.getId());
			
			em.getTransaction().begin();
			if(user != null) em.remove(user) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void deleteByKey(Integer key) {
		User user = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			user = em.find(User.class, key);
			
			em.getTransaction().begin();
			if(user != null) em.remove(user) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}
}
