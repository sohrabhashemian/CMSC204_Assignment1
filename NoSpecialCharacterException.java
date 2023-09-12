//Sohrab Hashemian

public class NoSpecialCharacterException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param NoSpecialCharacterException
	 * @return Tostring of exception
	 */
	public NoSpecialCharacterException()
	{
		super("The password must contain at least one special character");
	}

	/**
	 * @author Sohrab Hashemian
	 * @param NoSpecialCharacterException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " The password must contain at least one special character");
	}
}