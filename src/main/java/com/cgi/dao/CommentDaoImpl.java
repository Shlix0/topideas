package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cgi.model.Comment;
import com.cgi.utils.ContextDB;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> findAll() {
		EntityManager em = null;
		List<Comment> comments = null;
		
		try {
			comments = new ArrayList<Comment>();
			em = ContextDB.getInstance().getEmf().createEntityManager();

			Query query = em.createQuery("select co from Comment co");
			comments = query.getResultList();


		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return comments;
	}

	@Override
	public Comment findByKey(Long key) {
		EntityManager em = null;
		Comment comment = null;
		
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			
			comment = em.find(Comment.class, key);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
		return comment;
	}

	@Override
	public void add(Comment obj) {
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
	public Comment update(Comment obj) {
		Comment comment = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			comment = em.find(Comment.class, obj.getId());
			
			em.getTransaction().begin();
			if(comment != null) em.merge(obj);
			
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
	public void delete(Comment obj) {
		Comment comment = null;
		EntityManager em = null;
		try {
			
			em = ContextDB.getInstance().getEmf().createEntityManager();
			comment = em.find(Comment.class, obj.getId());
			
			em.getTransaction().begin();
			if(comment != null) em.remove(comment) ;
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
		Comment comment = null;
		EntityManager em = null;
		try {
			em = ContextDB.getInstance().getEmf().createEntityManager();
			comment = em.find(Comment.class, key);
			
			em.getTransaction().begin();
			if(comment != null) em.remove(comment) ;
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
		}
	}
}
