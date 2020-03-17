package fr.eni.javaee.suivirepas.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.suivirepas.bo.Aliment;
import fr.eni.javaee.suivirepas.bo.Repas;

public class RepasDAOJdbcImpl implements I_RepasDAO {

//	create table repas (
//			id int primary key identity(1,1),
//			dateRepas varchar(10),
//			heureRepas varchar(10)
//		);
//
//		create table  aliments  (
//			id int primary key identity(1,1),
//			nom varchar(150),
//			idRepas int references repas(id)
//		);

	private static final String TABLE_REPAS = "repas";
	private static final String TABLE_ALIMENTS = "aliments";

	private static final String COL_REPAS_DATE = "dateRepas";
	private static final String COL_REPAS_HEURE = "heureRepas";
	private static final String COL_REPAS_ID = "id";

	private static final String COL_ALIMENTS_NOM = "nom";
	private static final String COL_ALIMENTS_IDREPAS = "idRepas";
	private static final String COL_ALIMENTS_ID = "id";

	private static final String RQT_INSERT_REPAS = "INSERT INTO Repas (date, heure) VALUES(?,?);";
	private static final String RQT_INSERT_ALIMENT = "INSERT INTO Aliments (nom, idRepas) VALUES(?,?);";
	private static final String RQT_SELECT_ALL = "SELECT * FROM ?";
	private static final String RQT_SELECT_BY_ID = "SELECT * FROM ? WHERE id = ?";

	private static final String LIST_SEPARATOR = ", ";

	@Override
	public void insert(Repas repas) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RQT_INSERT_REPAS, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, repas.getDateRepas());
			pstmt.setString(2, repas.getHeureRepas());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			I_AlimentDAO daoAliment = DAOFactory.getAlimentDAO();

			if (rs.next()) {
				int idRepas = rs.getInt(1);

				repas.setId(idRepas);

				for (String ingredient : repas.getListeIngredients()) {
					daoAliment.insert(new Aliment(ingredient, idRepas));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Override
//	public List<Repas> selectAll() throws BusinessException {
//		List<Repas> resultat = new ArrayList<>();
//
//		try (Connection cnx = ConnectionProvider.getConnection()) {
//			PreparedStatement pstmt = cnx.prepareStatement(RQT_SELECT_ALL);
//
//			pstmt.setString(1, TABLE_REPAS);
//
//			ResultSet rs = pstmt.executeQuery();
//
//			String fmt = "dd/MM/yyyy HH:mm:ss";
//			DateFormat df = new SimpleDateFormat(fmt);
//
//			while (rs.next()) {
//				// id int
//				// dateRepas dateTime
//				// idRepas --> listAliment
//
//				Date dt = df.parse(rs.getDate(COL_REPAS_DATE).toString());
//				String timeOnly = new SimpleDateFormat("HH:mm").format(dt);
//				String dateOnly = new SimpleDateFormat("dd/MM/yyyy").format(dt);
//
//				List<Aliment> ingredients = DAOFactory.getAlimentDAO().selectByRepasId(rs.getInt(COL_REPAS_ID));
//
//				resultat.add(new Repas(rs.getInt(COL_REPAS_ID), dateOnly, timeOnly,
//						((Repas) ingredients).joinListeIngredients(", ")));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			BusinessException businessException = new BusinessException();
//			if (e.getMessage().contains("CK_AVIS_note")) {
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
//			} else {
//				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
//			}
//			throw businessException;
//		}
//
//		return resultat;
//
//	}

	@Override
	public List<Repas> selectAll() {

		List<Repas> resultat = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(RQT_SELECT_ALL);

			pstmt.setString(1, TABLE_REPAS);

			ResultSet rs = pstmt.executeQuery();

			I_AlimentDAO daoAliment = DAOFactory.getAlimentDAO();

			while (rs.next()) {
				// id int
				// dateRepas string
				// heureRepas string
				// <-- listeAliments

				List<Aliment> ingredients = daoAliment.selectByRepasId(rs.getInt(COL_REPAS_ID));

				resultat.add(new Repas(
						rs.getInt(COL_REPAS_ID), 
						rs.getString(COL_REPAS_DATE),
						rs.getString(COL_REPAS_HEURE), 
						joinListe(ingredients)) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultat;

	}

	@Override
	public Repas selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String joinListe(List<Aliment> liste) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < liste.size(); i++) {
			String sep = (i == (liste.size() - 1)) ? "" : LIST_SEPARATOR; 
			sb.append(liste.get(i) + sep);
		}
		return sb.toString();
	}

}
