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
public class DetailCommandeServiceImpl implements DetailCommandeService {
	@Autowired
	DetailCommandeDAO dao ;
	
	public void setDao(DetailCommandeDAO dao) {
		this.dao = dao;
	}

	public void add(DetailCommande DetailCommande) {
		dao.add(DetailCommande);
		
	}

	public DetailCommande get(int id) {
		return dao.get(id);
	}

	public void edit(DetailCommande DetailCommande) {
		dao.edit(DetailCommande);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<DetailCommande> list() {
		return dao.list();
	}

}
