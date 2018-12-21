package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.Role;
import com.cgi.model.User;
import com.cgi.utils.ContextDB;

public class RoleDaoImpl implements RoleDao {

	@Override
	public List<Role> findAll() {
		EntityManager em = null;
		List<Role> roles = null;
		
		try {
			roles = new ArrayList<Role>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select u from User u");
			roles = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return roles;
	}

	@Override
	public Role findByKey(Integer key) {
		EntityManager em = null;
		Role role = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			role = em.find(Role.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return role;
	}

	@Override
	public void add(Role obj) {
		Role role = null;
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
	public Role update(Role obj) {
		Role role = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			role = em.find(Role.class, obj.getId());
			
			em.getTransaction().begin();
			if(role != null) em.merge(obj);
			
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
	public void delete(Role obj) {
		Role role = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			role = em.find(Role.class, obj.getId());
			
			em.getTransaction().begin();
			if(role != null) em.remove(role) ;
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
		Role role = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			role = em.find(Role.class, key);
			
			em.getTransaction().begin();
			if(role != null) em.remove(role) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}
}
