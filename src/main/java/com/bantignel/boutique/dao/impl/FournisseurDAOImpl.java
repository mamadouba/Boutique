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
public class FournisseurDAOImpl implements FournisseurDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(Fournisseur fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(fournisseur);
		tx.commit();
		session.close();
	}

	public Fournisseur get(int id) {
		Session session = sessionFactory.openSession();
        Fournisseur obj = (Fournisseur) session.get(Fournisseur.class,id);
        session.close();
        return obj;
	}

	public void edit(Fournisseur fournisseur) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fournisseur);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Fournisseur fournisseur = (Fournisseur) session.get(Fournisseur.class,id);;
        session.delete(fournisseur);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Fournisseur> list() {
		Session session = sessionFactory.openSession();
        List<Fournisseur> list = session.createQuery("from Fournisseur").list();
        session.close();
        return list;
	}
	
}
