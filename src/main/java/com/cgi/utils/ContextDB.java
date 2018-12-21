package com.cgi.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextDB {

	private static ContextDB instance = null;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("topideasPersistence");
	
	private ContextDB() {}

	public static ContextDB getInstance() {
		if (instance == null) {
			instance = new ContextDB();
		}

		return instance;
	}
	
	public static void stop() {
		ContextDB inst = getInstance();
		inst.getEmf().close();
		instance = null;
	}

	public EntityManagerFactory getEmf() {
		return emf;
}



}
