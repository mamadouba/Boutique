package com.bantignel.boutique.dao;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface ClientDAO {
	public void add(Client client);
	public Client get(int id);
	public void edit(Client client);
	public void delete(int id);
	public List<Client> list();
}
