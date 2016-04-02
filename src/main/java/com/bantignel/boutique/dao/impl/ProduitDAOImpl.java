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
public class ProduitDAOImpl implements ProduitDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(produit);
		tx.commit();
		session.close();
	}

	public Produit get(int id) {
		Session session = sessionFactory.openSession();
        Produit obj = (Produit) session.get(Produit.class,id);
        session.close();
        return obj;
	}

	public void edit(Produit produit) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(produit);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Produit produit = (Produit) session.get(Produit.class,id);;
        session.delete(produit);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Produit> list() {
		Session session = sessionFactory.openSession();
        List<Produit> list = session.createQuery("from Produit").list();
        session.close();
        return list;
	}
	
}
