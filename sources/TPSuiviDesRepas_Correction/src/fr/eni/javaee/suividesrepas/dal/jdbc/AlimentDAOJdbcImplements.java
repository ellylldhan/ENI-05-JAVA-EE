package fr.eni.javaee.suividesrepas.dal.jdbc;

//code Aurélien Martineau

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;
import fr.eni.javaee.suividesrepas.dal.DALException;
import fr.eni.javaee.suividesrepas.dal.DAO;



public class AlimentDAOJdbcImplements implements DAO<Aliment> {
	private static final String SQL_INSERT="insert into aliments(libelle,idRepas) values(?,?);";
	private static final String SQL_SELECT_ALL="select * from aliments inner join repas on aliment.idRepas=repas.id;";
	private static final String SQL_SELECT_BY_ID="select * from aliments inner join repas on aliment.idRepas=repas.id where id=?;";
	private static final String SQL_SELECT_BY_IDREPAS="select * from aliments inner join repas on aliment.idRepas=repas.id where idRepas=?;";
	private static final String SQL_UPDATE="update aliments set libelle=?,idRepas=? where id=?;";
	private static final String SQL_DELETE="delete from aliments where id=?;";

	@Override
	public void insert(Aliment element) throws DALException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection cnx=null;
		PreparedStatement rqt=null;
		try
		{
			 cnx = ConnectionProvider.getConnection();
			 rqt=cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			 rqt.setString(1, element.getNom());
			 rqt.setInt(2, element.getUnRepas().getId());
			 int nb= rqt.executeUpdate();
			 if(nb==1)
			 {
				 ResultSet rs = rqt.getGeneratedKeys();
				 if(rs.next())
				 {
					 element.setIdentifiant(rs.getInt(1));
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Erreur insert Aliments "+element,e);
		}
	}

	@Override
	public void update(Aliment element) throws DALException {
		// TODO Auto-generated method stub
		Connection cnx=null;
		PreparedStatement rqt=null;
		try
		{
			 cnx = ConnectionProvider.getConnection();
			 rqt=cnx.prepareStatement(SQL_UPDATE);
			 rqt.setString(1, element.getNom());
			 rqt.setInt(2, element.getUnRepas().getId());
			 rqt.setInt(3, element.getIdentifiant());
			 int nb= rqt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Erreur update Aliments "+element,e);
		}
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		Connection cnx=null;
		PreparedStatement rqt=null;
		try
		{
			 cnx = ConnectionProvider.getConnection();
			 rqt=cnx.prepareStatement(SQL_DELETE);
			 rqt.setInt(1, id);
			 int nb= rqt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Erreur delete Aliment "+id,e);
		}
	}

	@Override
	public List<Aliment> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Connection cnx=null;
		Statement rqt=null;
		Aliment aliment =null;
		List<Aliment>lesAliments = new ArrayList<>();
		try
		{
			 cnx = ConnectionProvider.getConnection();
			 rqt=cnx.createStatement();
			 ResultSet rs= rqt.executeQuery(SQL_SELECT_ALL);
			 while(rs.next())
			 {
				 aliment = new Aliment(rs.getInt(1),rs.getString(2),new Repas(rs.getInt(3),rs.getDate(4).toLocalDate(),rs.getTime(5).toLocalTime()));
				 lesAliments.add(aliment);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Erreur selectAll Repas ",e);
		}
		return lesAliments;
	}

	@Override
	public Aliment selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
