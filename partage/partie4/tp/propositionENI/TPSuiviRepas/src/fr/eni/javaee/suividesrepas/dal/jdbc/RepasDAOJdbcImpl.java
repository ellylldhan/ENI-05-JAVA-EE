package fr.eni.javaee.suividesrepas.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suividesrepas.BusinessException;
import fr.eni.javaee.suividesrepas.bo.Aliment;
import fr.eni.javaee.suividesrepas.bo.Repas;
import fr.eni.javaee.suividesrepas.dal.CodesResultatDAL;
import fr.eni.javaee.suividesrepas.dal.RepasDAO;

public class RepasDAOJdbcImpl implements RepasDAO {

	private static final String INSERT_REPAS="insert into repas(dateRepas, heureRepas) values(?,?)";
	private static final String INSERT_ALIMENT="insert into aliments(libelle, idRepas) values(?,?)";
	private static final String SELECT_ALL=" SELECT " + 
											"	r.id as idRepas," + 
											"	r.dateRepas," + 
											"	r.heureRepas," + 
											"	a.id as idAliment," + 
											"	a.libelle" + 
											" FROM" + 
											"	REPAS r" + 
											"	INNER JOIN ALIMENTS a ON r.id=a.idRepas" +
											"	ORDER BY r.dateRepas desc, r.heureRepas desc";
	private static final String SELECT_UNE_DATE=" SELECT " + 
											"	r.id as idRepas," + 
											"	r.dateRepas," + 
											"	r.heureRepas," + 
											"	a.id as idAliment," + 
											"	a.libelle" + 
											" FROM" + 
											"	REPAS r" + 
											"	INNER JOIN ALIMENTS a ON r.id=a.idRepas" +
											" WHERE r.dateRepas=?"+
											"	ORDER BY r.dateRepas desc, r.heureRepas desc";
	
	@Override
	public void insert(Repas repas) throws BusinessException {
		if(repas==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setDate(1, java.sql.Date.valueOf(repas.getDate()));
				pstmt.setTime(2, java.sql.Time.valueOf(repas.getHeure()));
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					repas.setIdentifiant(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				pstmt = cnx.prepareStatement(INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);
				for (Aliment aliment : repas.getListeAliments()) {
					pstmt.setString(1, aliment.getNom());
					pstmt.setInt(2, repas.getIdentifiant());
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if(rs.next())
					{
						aliment.setIdentifiant(rs.getInt(1));
					}
					rs.close();
				}
				pstmt.close();
				cnx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}

	}

	@Override
	public List<Repas> select() throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			Repas repasCourant=new Repas();
			while(rs.next())
			{
				if(rs.getInt("idRepas")!=repasCourant.getIdentifiant())
				{
					repasCourant = repasBuilder(rs);
					listeRepas.add(repasCourant);
				}
				Aliment aliment = alimentBuilder(rs);
				repasCourant.getListeAliments().add(aliment);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw businessException;
		}
		return listeRepas;
	}

	@Override
	public List<Repas> select(LocalDate dateRecherchee) throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UNE_DATE);
			pstmt.setDate(1, java.sql.Date.valueOf(dateRecherchee));
			ResultSet rs = pstmt.executeQuery();
			Repas repasCourant=new Repas();
			while(rs.next())
			{
				if(rs.getInt("idRepas")!=repasCourant.getIdentifiant())
				{
					repasCourant = repasBuilder(rs);
					listeRepas.add(repasCourant);
				}
				Aliment aliment = alimentBuilder(rs);
				repasCourant.getListeAliments().add(aliment);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_REPAS_ECHEC);
			throw businessException;
		}
		return listeRepas;
	}

	
	@Override
	public List<Repas> select(int page) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Aliment alimentBuilder(ResultSet rs) throws SQLException {
		Aliment aliment = new Aliment(rs.getInt("idAliment"), rs.getString("libelle"));
		return aliment;
	}

	private Repas repasBuilder(ResultSet rs) throws SQLException {
		Repas repasCourant;
		repasCourant=new Repas();
		repasCourant.setIdentifiant(rs.getInt("idRepas"));
		repasCourant.setDate(rs.getDate("dateRepas").toLocalDate());
		repasCourant.setHeure(rs.getTime("heureRepas").toLocalTime());
		return repasCourant;
	}


}
