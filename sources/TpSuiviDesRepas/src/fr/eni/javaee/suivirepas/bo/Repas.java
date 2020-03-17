package fr.eni.javaee.suivirepas.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Repas implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String dateRepas;
	private String heureRepas;
	private List<String> listeIngredients;
//	private String listeIngredients;

	public Repas() {
		super();
	}

	public Repas(int id, String dateRepas, String heureRepas, String ingredients) {
		super();
		this.id = id;
		this.dateRepas = dateRepas;
		this.heureRepas = heureRepas;
		this.listeIngredients = Arrays.asList(ingredients.split("\\s*,\\s*"));
	}

	public Repas(String dateRepas, String heureRepas, String ingredients) {
		super();
		this.dateRepas = dateRepas;
		this.heureRepas = heureRepas;
		this.listeIngredients = Arrays.asList(ingredients.split("\\s*,\\s*"));
	}

	public List<String> getListeIngredients() {
		return listeIngredients;
	}

	public void setListeIngredients(List<String> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}
	
	public void setListeIngredients(String listeIngredients) {
		this.listeIngredients = Arrays.asList(listeIngredients.split("\\s*,\\s*"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateRepas() {
		return dateRepas;
	}

	public void setDateRepas(String dateRepas) {
		this.dateRepas = dateRepas;
	}

	public String getHeureRepas() {
		return heureRepas;
	}

	public void setHeureRepas(String heureRepas) {
		this.heureRepas = heureRepas;
	}

	public LocalDateTime convertDateTime() {
		return LocalDateTime.of(LocalDate.parse(this.dateRepas), LocalTime.parse(this.heureRepas));
	}

	public LocalDateTime combineStringToDateTime(String date, String time) {
		return LocalDateTime.of(LocalDate.parse(date), LocalTime.parse(time));
	}
	
	
	public String joinListeIngredients(String separateur) {
		// TODO Auto-generated method stub
		return this.listeIngredients.stream().collect(Collectors.joining(separateur));
	}

}
