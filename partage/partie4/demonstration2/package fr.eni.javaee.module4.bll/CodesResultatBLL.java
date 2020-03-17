package fr.eni.javaee.module4.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la description de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_AVIS_DESCRIPTION_ERREUR=20000;
	/**
	 * Echec quand la note de l'avis ne respecte pas les règles définies
	 */
	public static final int REGLE_AVIS_NOTE_ERREUR=20001;
	
	
}
