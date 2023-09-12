//Sohrab Hashemian

public class WeakPasswordException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param WeakPasswordException
	 * @return Tostring of exception
	 */
	public WeakPasswordException()
	{
		super("Password is OK but weak");
	}
	
	/**
	 * @author Sohrab Hashemian
	 * @param WeakPasswordException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " Password is OK but weak");
	}
}