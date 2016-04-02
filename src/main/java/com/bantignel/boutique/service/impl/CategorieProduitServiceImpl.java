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
public class CategorieProduitServiceImpl implements CategorieProduitService {
	@Autowired
	CategorieProduitDAO dao ;
	
	public void setDao(CategorieProduitDAO dao) {
		this.dao = dao;
	}

	public void add(CategorieProduit CategorieProduit) {
		dao.add(CategorieProduit);
		
	}

	public CategorieProduit get(int id) {
		return dao.get(id);
	}

	public void edit(CategorieProduit CategorieProduit) {
		dao.edit(CategorieProduit);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<CategorieProduit> list() {
		return dao.list();
	}

}
