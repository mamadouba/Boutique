package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface DetailCommandeService {
	public void add(DetailCommande DetailCommande);
	public DetailCommande get(int id);
	public void edit(DetailCommande DetailCommande);
	public void delete(int id);
	public List<DetailCommande> list();
}
