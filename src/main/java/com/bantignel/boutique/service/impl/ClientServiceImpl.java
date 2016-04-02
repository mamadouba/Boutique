package com.bantignel.boutique.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bantignel.boutique.dao.*;
import com.bantignel.boutique.model.*;
import com.bantignel.boutique.service.*;
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDAO dao ;
	
	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}

	public void add(Client Client) {
		dao.add(Client);
		
	}

	public Client get(int id) {
		return dao.get(id);
	}

	public void edit(Client Client) {
		dao.edit(Client);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Client> list() {
		return dao.list();
	}

}
