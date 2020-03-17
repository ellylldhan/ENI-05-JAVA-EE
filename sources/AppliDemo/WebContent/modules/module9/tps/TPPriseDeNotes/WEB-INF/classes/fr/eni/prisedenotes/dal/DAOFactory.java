package fr.eni.prisedenotes.dal;

public abstract class DAOFactory {
	
	public static NoteDAO getNoteDAO()
	{
		return new NoteDAOJdbcImpl();
	}
}
	