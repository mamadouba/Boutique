package com.bantignel.boutique.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDES")
public class Commande implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idCommande;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Employe employe;
	private Date dateCommande;
	private Date dateEnvoi;
	@OneToMany(mappedBy="commande")
	private Set<DetailCommande> detailCommande = new TreeSet<DetailCommande>();
	public Commande(Client client, Employe employe, Date dateCommande, Date dateEnvoi) {
		super();
		this.client = client;
		this.employe = employe;
		this.dateCommande = dateCommande;
		this.dateEnvoi = dateEnvoi;
	}
	public Commande() {
		super();
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public Client getclient() {
		return client;
	}
	public void setclient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public Set<DetailCommande> getDetailCommande() {
		return detailCommande;
	}
	public void setDetailCommande(Set<DetailCommande> detailCommande) {
		this.detailCommande = detailCommande;
	}
	
	
}
