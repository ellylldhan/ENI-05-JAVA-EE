package fr.eni.javaee.suivirepas.bll;

import fr.eni.javaee.suivirepas.bo.Repas;
import fr.eni.javaee.suivirepas.dal.DAOFactory;
import fr.eni.javaee.suivirepas.dal.I_RepasDAO;
import fr.eni.javaee.suivirepas.exceptions.BusinessException;

public class RepasManager {

	private I_RepasDAO repasDAO;
	private static final int INGREDIENT_MAX_LENGHT = 150;

	/**
	 * Le constructeur permet d'initialiser la variable membre avisDAO pour
	 * permettre une communication avec la base de données.
	 */
	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}

	/**
	 * @param description
	 * @param note
	 * @return un objet Avis en cas de succcès
	 * @throws BusinessException 
	 * @throws BusinessException
	 */
	public Repas ajouter(String date, String heure, String ingredients) throws BusinessException {
		Repas repas = new Repas(date, heure, ingredients);

		this.repasDAO.insert(repas);

		return repas;

//		Avis avis = new Avis(description, note);
//		
//		this.validerNote(avis,exception);
//		this.validerDescription(avis,exception);
//
//		if(!exception.hasErreurs())
//		{
//			this.avisDAO.insert(avis);
//		}
//		
//		if(exception.hasErreurs())
//		{
//			throw exception;
//		}
//		return avis;
	}

	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable
	 * membre note. En cas d'erreur, le code d'erreur est enregistré dans l'objet
	 * businessException.
	 * 
	 * @param avis
	 * @param businessException
	 */
//	private void validerNote(Avis avis, BusinessException businessException)
//	{
//		if(avis.getNote()<1 || avis.getNote()>5)
//		{
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_NOTE_ERREUR);
//		}
//	}

	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable
	 * membre description. En cas d'erreur, le code d'erreur est enregistré dans
	 * l'objet businessException.
	 * 
	 * @param avis
	 * @param businessException
	 */
//	private void validerDescription(Avis avis, BusinessException businessException)
//	{
//		if(avis.getDescription()==null  || avis.getDescription().equals("")|| avis.getDescription().length()>150)
//		{
//			businessException.ajouterErreur(CodesResultatBLL.REGLE_AVIS_DESCRIPTION_ERREUR);
//		}
//	}

}
