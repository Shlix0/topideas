package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.Category;
import com.cgi.utils.ContextDB;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
		EntityManager em = null;
		List<Category> categories = null;
		
		try {
			categories = new ArrayList<Category>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select u from User u");
			categories = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return categories;
	}

	@Override
	public Category findByKey(Long key) {
		EntityManager em = null;
		Category category = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			category = em.find(Category.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return category;
	}

	@Override
	public void add(Category obj) {
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
	public Category update(Category obj) {
		Category category = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			category = em.find(Category.class, obj.getId());
			
			em.getTransaction().begin();
			if(category != null) em.merge(obj);
			
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
	public void delete(Category obj) {
		Category category = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			category = em.find(Category.class, obj.getId());
			
			em.getTransaction().begin();
			if(category != null) em.remove(category) ;
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
		Category category = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			category = em.find(Category.class, key);
			
			em.getTransaction().begin();
			if(category != null) em.remove(category) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}
}
