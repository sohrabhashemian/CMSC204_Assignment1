//Sohrab Hashemian

public class NoLowerAlphaException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param NoLowerAlphaException
	 * @return Tostring of exception
	 */
	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
	
	/**
	 * @author Sohrab Hashemian
	 * @param NoLowerAlphaException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " The password must contain at least one lowercase alphabetic character");
	}
}