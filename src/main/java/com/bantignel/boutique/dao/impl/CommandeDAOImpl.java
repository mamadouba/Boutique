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
public class CommandeDAOImpl implements CommandeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(Commande commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(commande);
		tx.commit();
		session.close();
	}

	public Commande get(int id) {
		Session session = sessionFactory.openSession();
        Commande obj = (Commande) session.get(Commande.class,id);
        session.close();
        return obj;
	}

	public void edit(Commande commande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(commande);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Commande commande = (Commande) session.get(Commande.class,id);;
        session.delete(commande);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Commande> list() {
		Session session = sessionFactory.openSession();
        List<Commande> list = session.createQuery("from Commande").list();
        session.close();
        return list;
	}
	
}
