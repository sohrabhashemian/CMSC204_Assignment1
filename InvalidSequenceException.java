//Sohrab Hashemian

public class InvalidSequenceException extends Exception
{
	/**
	 * @author Sohrab Hashemian
	 * @param InvalidSequenceException
	 * @return Tostring of exception
	 */
	public InvalidSequenceException()
	{
		super("The password cannoot contain more than two of the same character in a sequence");
	}
	
	/**
	 * @author Sohrab Hashemian
	 * @param InvalidSequenceException
	 * @return Tostring of exception
	 */
	public static String ExceptionMessage(String password)
	{
		return(password + " The password cannot contain more than two of the same character in a sequence");
	}
}