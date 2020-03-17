package fr.eni.javaee.suivirepas.dal;

import java.util.List;

import fr.eni.javaee.suivirepas.bo.Aliment;
import fr.eni.javaee.suivirepas.exceptions.BusinessException;

public interface I_AlimentDAO {

	public void insert(Aliment aliment) throws BusinessException;
	
	public void insertWithId(Aliment aliment, int idRepas);

	public List<Aliment> selectAll() throws BusinessException;

	public Aliment selectById(int id) throws BusinessException;

	public List<Aliment> selectByRepasId(int int1) throws BusinessException;

}
