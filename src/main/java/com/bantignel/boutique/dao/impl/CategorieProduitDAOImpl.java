package com.bantignel.boutique.dao.impl;
import com.bantignel.boutique.model.*;
import com.bantignel.boutique.dao.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CategorieProduitDAOImpl implements CategorieProduitDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(CategorieProduit categorieProduit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(categorieProduit);
		tx.commit();
		session.close();
	}

	public CategorieProduit get(int id) {
		Session session = sessionFactory.openSession();
        CategorieProduit obj = (CategorieProduit) session.get(CategorieProduit.class,id);
        session.close();
        return obj;
	}

	public void edit(CategorieProduit categorieProduit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(categorieProduit);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CategorieProduit categorieProduit = (CategorieProduit) session.get(CategorieProduit.class,id);;
        session.delete(categorieProduit);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<CategorieProduit> list() {
		Session session = sessionFactory.openSession();
        List<CategorieProduit> list = session.createQuery("from CategorieProduit").list();
        session.close();
        return list;
	}
	
}
