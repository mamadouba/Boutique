package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface ProduitService {
	public void add(Produit Produit);
	public Produit get(int id);
	public void edit(Produit Produit);
	public void delete(int id);
	public List<Produit> list();
}
