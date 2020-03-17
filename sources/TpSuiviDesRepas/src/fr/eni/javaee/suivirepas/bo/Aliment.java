package fr.eni.javaee.suivirepas.bo;

import java.io.Serializable;
import java.util.stream.Collectors;

public class Aliment implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private int idRepas;
	
	
	public Aliment() {
		// TODO Auto-generated constructor stub
	}


	public Aliment(int id, String nom, int idRepas) {
		super();
		this.id = id;
		this.nom = nom;
		this.idRepas = idRepas;
	}
	
	


	public Aliment(String nom, int idRepas) {
		super();
		this.nom = nom;
		this.idRepas = idRepas;
	}


	public int getIdRepas() {
		return idRepas;
	}


	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}





	
	
	
	
	

}
