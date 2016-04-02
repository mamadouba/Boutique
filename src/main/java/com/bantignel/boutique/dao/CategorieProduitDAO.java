package com.bantignel.boutique.dao;

import com.bantignel.boutique.model.*;
import java.util.List;


public interface CategorieProduitDAO {
	public void add(CategorieProduit CategorieProduit);
	public CategorieProduit get(int id);
	public void edit(CategorieProduit CategorieProduit);
	public void delete(int id);
	public List<CategorieProduit> list();
}
