package com.bantignel.boutique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETAIL_COMMANDES")
public class DetailCommande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDetailCommande;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Commande commande;
	private int quantite;
	public DetailCommande(Produit produit, Commande commande, int quantite) {
		super();
		this.produit = produit;
		this.commande = commande;
		this.quantite = quantite;
	}
	
	public DetailCommande() {
		super();
	}

	public int getIdDetailCommande() {
		return idDetailCommande;
	}
	public void setIdDetailCommande(int idDetailCommande) {
		this.idDetailCommande = idDetailCommande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
}
