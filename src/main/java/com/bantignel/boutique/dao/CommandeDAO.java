package com.bantignel.boutique.dao;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface CommandeDAO {
	public void add(Commande Commande);
	public Commande get(int id);
	public void edit(Commande Commande);
	public void delete(int id);
	public List<Commande> list();
}
