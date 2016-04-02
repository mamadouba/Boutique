package com.bantignel.boutique.model;


import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FOURNISSEURS")
@PrimaryKeyJoinColumn(name="id")
public class Fournisseur  extends Person  {
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="fournisseur")
	private Set<Produit> produits = new TreeSet<Produit>();
	public Fournisseur() {
		super();
	}
	public Fournisseur(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse);
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	
}
