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
public class EmployeServiceImpl implements EmployeService {
	@Autowired
	EmployeDAO dao ;
	
	public void setDao(EmployeDAO dao) {
		this.dao = dao;
	}

	public void add(Employe Employe) {
		dao.add(Employe);
		
	}

	public Employe get(int id) {
		return dao.get(id);
	}

	public void edit(Employe Employe) {
		dao.edit(Employe);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Employe> list() {
		return dao.list();
	}

}
