//Sohrab Hashemian

public class UnmatchedException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param UnmatchedException
	 * @return Tostring of exception
	 */
	public UnmatchedException()
	{
		super("Passwords do not match");
	}

	/**
	 * @author Sohrab Hashemian
	 * @param UnmatchedException
	 * @return Tostring of exception
	 */
	public static void comparePasswords(String password, String confirm) throws UnmatchedException
	{
		if (!(password.equals(confirm)))
		{
			throw new UnmatchedException();
		}
	}
}