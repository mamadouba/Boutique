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
public class DetailCommandeDAOImpl implements DetailCommandeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(DetailCommande detailCommande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(detailCommande);
		tx.commit();
		session.close();
	}

	public DetailCommande get(int id) {
		Session session = sessionFactory.openSession();
        DetailCommande obj = (DetailCommande) session.get(DetailCommande.class,id);
        session.close();
        return obj;
	}

	public void edit(DetailCommande detailCommande) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(detailCommande);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		DetailCommande detailCommande = (DetailCommande) session.get(DetailCommande.class,id);;
        session.delete(detailCommande);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<DetailCommande> list() {
		Session session = sessionFactory.openSession();
        List<DetailCommande> list = session.createQuery("from DetailCommande").list();
        session.close();
        return list;
	}
	
}
