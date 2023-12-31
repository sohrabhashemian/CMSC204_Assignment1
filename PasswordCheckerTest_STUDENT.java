//Sohrab Hashemian

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Sohrab Hashemian
 *
 */
public class PasswordCheckerTest_STUDENT
{
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception
	{
		String[] p = {"112233ZZ!", "rostamYYY3@", "Tom5%", "jonas77", "novem30", "coDM2", "CherryvvvWWoo)", "ii00Oo", "computerSci", "jjUUU?789"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
	}

	@After
	public void tearDown() throws Exception
	{
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("VBzxc"));
			assertTrue("Did not throw LengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("456789"));
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("554433U"));
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try
		{
			assertEquals(true,PasswordCheckerUtility.isWeakPassword("(iO9876"));
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try
		{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("456*1ZZZaa"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try
		{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("qwerty1q@34"));
		 	assertTrue("Did not throw a NoDigitExcepetion",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitExcepetion",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("asdfghjkQW12&"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcepetion",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",false);
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterExcepetion",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords()
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "112233ZZ!");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "rostamYYY3@");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
		
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "Tom5%");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
				scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "jonas77");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "novem30");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "coDM2");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long") );
		
		scan = new Scanner(results.get(6));  
		assertEquals(scan.next(), "CherryvvvWWoo)");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(7));  
		assertEquals(scan.next(), "ii00Oo");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		scan = new Scanner(results.get(8)); 
		assertEquals(scan.next(), "computerSci");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(9));  
		assertEquals(scan.next(), "jjUUU?789");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence") );
	}
}