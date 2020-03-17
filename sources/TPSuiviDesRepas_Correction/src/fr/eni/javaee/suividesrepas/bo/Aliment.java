package fr.eni.javaee.suividesrepas.bo;

import java.io.Serializable;

public class Aliment implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private int identifiant;
	private String nom;
	private Repas unRepas;
	
	public Repas getUnRepas() {
		return unRepas;
	}
	public void setUnRepas(Repas unRepas) {
		this.unRepas = unRepas;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Aliment() {

	}
	public Aliment(String nom) {
		super();
		this.nom = nom;
	}
	public Aliment(int identifiant, String nom) {
		this(nom);
		this.identifiant = identifiant;
	}
	public Aliment(int identifiant, String nom, Repas unRepas) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.unRepas = unRepas;
	}
	@Override
	public String toString() {
		return "Aliment [identifiant=" + identifiant + ", nom=" + nom + "]";
	}

	
}









