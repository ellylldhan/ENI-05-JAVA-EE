package fr.eni.javaee.suivirepas.dal;

import java.util.List;

import fr.eni.javaee.suivirepas.bo.Repas;
import fr.eni.javaee.suivirepas.exceptions.BusinessException;

public interface I_RepasDAO {

	public void insert(Repas repas) throws BusinessException;

	public List<Repas> selectAll() throws BusinessException;

	public Repas selectById(int id) throws BusinessException;

}
