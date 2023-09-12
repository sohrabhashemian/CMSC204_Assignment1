//Sohrab Hashemian

import java.util.ArrayList;

public class PasswordCheckerUtility
{
	public static boolean isValidPassword(String password) throws LengthException , NoUpperAlphaException , NoLowerAlphaException , NoDigitException , NoSpecialCharacterException , InvalidSequenceException
	{
		if ( isValidLength(password) && hasUpperAlpha(password) && hasDigit(password) && hasLowerAlpha(password) && hasSpecialChar(password) && NoSameCharInSequence(password) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if ( (password.length() >= 6) && (password.length() <= 9) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException , LengthException , NoUpperAlphaException , NoLowerAlphaException , NoDigitException , NoSpecialCharacterException , InvalidSequenceException
	{
		if ( (isValidPassword(password)) && (hasBetweenSixAndNineChars(password)) )
		{
			throw new WeakPasswordException();
		}
		else
		{
			return false;
		}
	}
	
	public static void comparePasswords(String password, String confirm) throws UnmatchedException
	{
		if (!(password.equals(confirm)))
		{
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String confirm)
	{
		if (password.equals(confirm))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() < 6)
		{
			throw new LengthException();
		}
		else
		{
			return true;
		}
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		if (password.equals(password.toLowerCase())) 
		{
			throw new NoUpperAlphaException();
		}
		else
		{
			return true;
		}
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		if (password.equals(password.toUpperCase()))
		{
			throw new NoLowerAlphaException();
		}
		else
		{
			return true;
		}
	}
	
	public static boolean hasDigit(String password) throws NoDigitException
	{
		for (int q=0 ; q<password.length() ; q++)
		{
			if (Character.isDigit(password.charAt(q)))
			{
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		char[] list = password.toCharArray();
		
		for (char q : list)
		{
		    if ( !(Character.isLetterOrDigit(q)) && !(Character.isSpaceChar(q)) )
		    {
		        return true;
		    }
		}
		throw new NoSpecialCharacterException();
	}
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		String[] letter = password.split("");
		
		for (int q=0 ; q<letter.length-2 ; q++)
		{
			if ( (letter[q].equals(letter[q+1])) && (letter[q+1].equals(letter[q+2])) )
			{
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> checksum = new ArrayList<String>();

		for (String temp : passwords)
		{
			try
			{
				isValidPassword(temp);
			}
			catch (LengthException e)
			{
				checksum.add(LengthException.ExceptionMessage(temp));
			}
			catch (NoUpperAlphaException e)
			{
				checksum.add(NoUpperAlphaException.ExceptionMessage(temp));
			}
			catch (NoLowerAlphaException e)
			{
				checksum.add(NoLowerAlphaException.ExceptionMessage(temp));
			}
			catch (NoDigitException e)
			{
				checksum.add(NoDigitException.ExceptionMessage(temp));
			}
			catch (NoSpecialCharacterException e)
			{
				checksum.add(NoSpecialCharacterException.ExceptionMessage(temp));
			}
			catch (InvalidSequenceException e)
			{
				checksum.add(InvalidSequenceException.ExceptionMessage(temp));
			}
		}
		return checksum;
	}	
}