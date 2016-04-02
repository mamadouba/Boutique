package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface CategorieProduitService {
	public void add(CategorieProduit CategorieProduit);
	public CategorieProduit get(int id);
	public void edit(CategorieProduit CategorieProduit);
	public void delete(int id);
	public List<CategorieProduit> list();
}
