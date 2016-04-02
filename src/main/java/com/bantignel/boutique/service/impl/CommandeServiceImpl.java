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
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	CommandeDAO dao ;
	
	public void setDao(CommandeDAO dao) {
		this.dao = dao;
	}

	public void add(Commande Commande) {
		dao.add(Commande);
		
	}

	public Commande get(int id) {
		return dao.get(id);
	}

	public void edit(Commande Commande) {
		dao.edit(Commande);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Commande> list() {
		return dao.list();
	}

}
