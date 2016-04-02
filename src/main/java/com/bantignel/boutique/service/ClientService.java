package com.bantignel.boutique.service;
import com.bantignel.boutique.model.*;
import java.util.List;


public interface ClientService {
	public void add(Client client);
	public Client get(int id);
	public void edit(Client client);
	public void delete(int id);
	public List<Client> list();
}
