package com.bantignel.boutique.dao;

import com.bantignel.boutique.model.*;
import java.util.List;


public interface FournisseurDAO {
	public void add(Fournisseur Fournisseur);
	public Fournisseur get(int id);
	public void edit(Fournisseur Fournisseur);
	public void delete(int id);
	public List<Fournisseur> list();
}
