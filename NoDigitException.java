//Sohrab Hashemian

public class NoDigitException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param NoDigitException
	 * @return Tostring of exception
	 */
	public NoDigitException()
	{
		super("The password must contain at least one digit");
	}

	/**
	 * @author Sohrab Hashemian
	 * @param NoDigitException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " The password must contain at least one digit");
	}
}