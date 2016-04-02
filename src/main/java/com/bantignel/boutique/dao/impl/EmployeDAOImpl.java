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
public class EmployeDAOImpl implements EmployeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(Employe client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(client);
		tx.commit();
		session.close();
	}

	public Employe get(int id) {
		Session session = sessionFactory.openSession();
        Employe obj = (Employe) session.get(Employe.class,id);
        session.close();
        return obj;
	}

	public void edit(Employe client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(client);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employe client = (Employe) session.get(Employe.class,id);;
        session.delete(client);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Employe> list() {
		Session session = sessionFactory.openSession();
        List<Employe> list = session.createQuery("from Employe").list();
        session.close();
        return list;
	}
	
}
