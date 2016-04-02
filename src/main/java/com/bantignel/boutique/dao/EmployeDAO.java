package com.bantignel.boutique.dao;

import com.bantignel.boutique.model.*;
import java.util.List;


public interface EmployeDAO {
	public void add(Employe Employe);
	public Employe get(int id);
	public void edit(Employe Employe);
	public void delete(int id);
	public List<Employe> list();
}
