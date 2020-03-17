package fr.eni.javaee.suividesrepas.dal;

import java.util.List;

public interface DAO<T> {
void insert(T element) throws DALException;
void update (T element) throws DALException;
void delete (int id) throws DALException;
List<T> selectAll() throws DALException;
T selectById(int id) throws DALException;
}
