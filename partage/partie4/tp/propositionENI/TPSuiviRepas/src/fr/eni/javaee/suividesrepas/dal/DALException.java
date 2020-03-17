package fr.eni.javaee.suividesrepas.dal;

public class DALException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DALException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DALException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DALException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
@Override
public String getMessage()
{
	return "DAL - "+super.getMessage();
}
}
