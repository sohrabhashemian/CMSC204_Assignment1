//Sohrab Hashemian

public class NoUpperAlphaException extends Exception
{
	public NoUpperAlphaException()
	{
		super("The password must contain at least one uppercase alphabetic letter");
	}
	
	public static String ExceptionMessage(String password)
	{
		return(password + " The password must contain at least one uppercase alphabetic letter");
	}

	public static boolean hasUpperAlpha(String password)
	{
		for (int q=0 ; q<password.length() ; q++)
		{
			if (Character.isUpperCase(password.charAt(q)))
			{
				return true;
			}
		}
		return false;
	}
}