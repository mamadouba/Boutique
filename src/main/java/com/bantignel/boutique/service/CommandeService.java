package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface CommandeService {
	public void add(Commande Commande);
	public Commande get(int id);
	public void edit(Commande Commande);
	public void delete(int id);
	public List<Commande> list();
}
