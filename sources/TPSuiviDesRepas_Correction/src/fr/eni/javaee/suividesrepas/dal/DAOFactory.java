package fr.eni.javaee.suividesrepas.dal;

import fr.eni.javaee.suividesrepas.dal.jdbc.RepasDAOJdbcImpl;

public abstract class DAOFactory {
	
	public static RepasDAO getRepasDAO()
	{
		return new RepasDAOJdbcImpl();
	}
}
	