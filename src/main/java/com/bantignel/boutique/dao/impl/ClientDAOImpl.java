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
public class ClientDAOImpl implements ClientDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	public void add(Client client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(client);
		tx.commit();
		session.close();
	}

	public Client get(int id) {
		Session session = sessionFactory.openSession();
        Client obj = (Client) session.get(Client.class,id);
        session.close();
        return obj;
	}

	public void edit(Client client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(client);
		tx.commit();
        session.close();
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Client client = (Client) session.get(Client.class,id);;
        session.delete(client);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Client> list() {
		Session session = sessionFactory.openSession();
        List<Client> list = session.createQuery("from Client").list();
        session.close();
        return list;
	}
	
}
