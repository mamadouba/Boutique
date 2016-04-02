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
public class FournisseurServiceImpl implements FournisseurService {
	@Autowired
	FournisseurDAO dao ;
	
	public void setDao(FournisseurDAO dao) {
		this.dao = dao;
	}

	public void add(Fournisseur Fournisseur) {
		dao.add(Fournisseur);
		
	}

	public Fournisseur get(int id) {
		return dao.get(id);
	}

	public void edit(Fournisseur Fournisseur) {
		dao.edit(Fournisseur);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Fournisseur> list() {
		return dao.list();
	}

}
