package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface FournisseurService {
	public void add(Fournisseur Fournisseur);
	public Fournisseur get(int id);
	public void edit(Fournisseur Fournisseur);
	public void delete(int id);
	public List<Fournisseur> list();
}
