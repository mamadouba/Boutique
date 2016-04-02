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
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitDAO dao ;
	
	public void setDao(ProduitDAO dao) {
		this.dao = dao;
	}

	public void add(Produit Produit) {
		dao.add(Produit);
		
	}

	public Produit get(int id) {
		return dao.get(id);
	}

	public void edit(Produit Produit) {
		dao.edit(Produit);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Produit> list() {
		return dao.list();
	}

}
