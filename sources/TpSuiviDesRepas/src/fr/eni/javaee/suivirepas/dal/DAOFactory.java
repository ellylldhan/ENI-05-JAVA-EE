package fr.eni.javaee.suivirepas.dal;

public abstract class DAOFactory {
	
	public static I_AlimentDAO getAlimentDAO()
	{
		return new AlimentDAOJdbcImpl();
	}
	
	public static I_RepasDAO getRepasDAO()
	{
		return new RepasDAOJdbcImpl();
	}
}