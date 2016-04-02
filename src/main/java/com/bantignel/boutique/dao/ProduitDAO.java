package com.bantignel.boutique.dao;

import com.bantignel.boutique.model.*;
import java.util.List;


public interface ProduitDAO {
	public void add(Produit Produit);
	public Produit get(int id);
	public void edit(Produit Produit);
	public void delete(int id);
	public List<Produit> list();
}
