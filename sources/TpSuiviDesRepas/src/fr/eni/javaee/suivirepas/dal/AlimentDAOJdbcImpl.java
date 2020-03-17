package fr.eni.javaee.suivirepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.javaee.suivirepas.bo.Aliment;
import fr.eni.javaee.suivirepas.bo.Repas;
import fr.eni.javaee.suivirepas.exceptions.BusinessException;
import fr.eni.javaee.suivirepas.exceptions.CodesResultatDAL;

public class AlimentDAOJdbcImpl implements I_AlimentDAO {

//	private static final String RQT_INSERT_REPAS = "INSERT INTO Repas (date, heure) VALUES(?,?);";
	private static final String RQT_INSERT_ALIMENT = "INSERT INTO Aliments (nom, idRepas) VALUES(?,?);";
	private static final String RQT_SELECT_ALL = "SELECT * FROM ?";
	private static final String RQT_SELECT_BY_ID = "SELECT * FROM ? WHERE id = ?";
	private static final String RQT_SELECT_BY_IDREPAS = "SELECT * FROM ? WHERE idRepas = ?";
	private static final String TABLE_REPAS = "repas";
	private static final String TABLE_ALIMENTS = "aliments";
	private static final String COL_REPAS_DATE = "dateRepas";
	private static final String COL_REPAS_ID = "id";
	private static final String COL_ALIMENTS_ID = "id";
	private static final String COL_ALIMENTS_NOM = "nom";
	private static final String COL_ALIMENTS_IDREPAS = "idRepas";

	@Override
	public void insert(Aliment aliment) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RQT_INSERT_ALIMENT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, aliment.getNom());
			pstmt.setInt(2, aliment.getIdRepas());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				aliment.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
	}

	@Override
	public List<Aliment> selectAll() throws BusinessException {
		List<Aliment> resultat = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RQT_SELECT_ALL);

			pstmt.setString(1, TABLE_ALIMENTS);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				resultat.add(new Aliment(rs.getString("nom"), rs.getInt("idRepas")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}

		return resultat;

	}

	@Override
	public Aliment selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithId(Aliment aliment, int idRepas) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Aliment> selectByRepasId(int idRepas) throws BusinessException {
		// RQT_SELECT_BY_IDREPAS
		List<Aliment> resultat = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RQT_SELECT_BY_IDREPAS);

			pstmt.setString(1, TABLE_ALIMENTS);
			pstmt.setInt(2, idRepas);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				resultat.add(new Aliment(rs.getString("nom"), idRepas));
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}

		return resultat;

	}
}
