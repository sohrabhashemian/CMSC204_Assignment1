//Sohrab Hashemian

public class LengthException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param LengthException
	 * @return Tostring of exception
	 */
	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}

	/**
	 * @author Sohrab Hashemian
	 * @param LengthException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " The password must be at least 6 characters long");
	}
}