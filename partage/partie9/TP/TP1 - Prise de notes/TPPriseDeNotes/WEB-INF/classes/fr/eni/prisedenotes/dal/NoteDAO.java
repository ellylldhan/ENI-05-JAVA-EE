package fr.eni.prisedenotes.dal;

import java.util.List;

import fr.eni.prisedenotes.BusinessException;
import fr.eni.prisedenotes.bo.Note;

public interface NoteDAO {
	public void insert(Note note) throws BusinessException;
	public void delete(int id) throws BusinessException;
	public void update(Note note) throws BusinessException;
	public List<Note> selectAll() throws BusinessException;
	public Note selectById(int id) throws BusinessException;
}
