package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.Login;
import com.cgi.utils.ContextDB;

public class LoginDaoImpl implements LoginDao {

	@Override
	public List<Login> findAll() {
		EntityManager em = null;
		List<Login> logins = null;
		
		try {
			logins = new ArrayList<Login>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select l from Login l");
			logins = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return logins;
	}

	@Override
	public Login findByKey(Long key) {
		EntityManager em = null;
		Login login = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			login = em.find(Login.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return login;
	}

	@Override
	public void add(Login obj) {
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
	public Login update(Login obj) {
		Login login = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			login = em.find(Login.class, obj.getId());
			
			em.getTransaction().begin();
			if(login != null) em.merge(obj);
			
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
	public void delete(Login obj) {
		Login login = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			login = em.find(Login.class, obj.getId());
			
			em.getTransaction().begin();
			if(login != null) em.remove(login) ;
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
		Login login = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			login = em.find(Login.class, key);
			
			em.getTransaction().begin();
			if(login != null) em.remove(login) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}
}
