// Programming 01, Part 2 (Tasks 3 and 4)
// J Dive

public class AssessmentPartTwo {
	
	public int scrabbleScore(String aWord)
	{
		// 03 -Scrabble Score
		// Complete this method so that it returns the scrabble score for the word in aWord 							// ~ A Guest
		// In scrabble each letter is worth a number of points and each word is worth the								// ~ A Guest
		// sum of the scores of the letters in it. For this assignment we will ignore									// ~ A Guest
		// double/treble letter/word bonuses.																			// ~ A Guest
		// The English language points per letter can be found at														// ~ A Guest
		// https://en.wikipedia.org/wiki/Scrabble_letter_distributions													// ~ A Guest
		// You will need to come up with a way of connecting each letter to its score and								// ~ A Guest
		// a way of identifying each letter in the word.																// ~ A Guest
		
		int sum = 0; // Initialise variables, sum will always start at 0
		String[] letters = new String[aWord.length()]; // Creates string array as long as the characters in aWord
		String character;
		
		
		for (int i = 0; i < aWord.length(); i++) // Applies score for each letter in word
		{
			character = Character.toString(aWord.charAt(i)); // Takes character as the next part of the string used this loop
			character = character.toUpperCase(); // Standardises case, as it is irrelevant to score but prevents checking for 52 possible characters
			letters[i] = character; // Uses character as the current string variable to be tested
			switch(character) // Select case but Java
			{
				case "A": case "E": case "I": case "O": case "N": case "R": case "T": case "L": case "S": case "U": { sum = sum + 1; break; }
				case "D": case "G": { sum = sum + 2; break; } // From scrabble scores: each line has every letter giving that amount of points
				case "B": case "C": case "M": case "P": { sum = sum + 3; break; }  // Scores sourced from Wikipedia (as requested)
				case "F": case "H": case "V": case "W": case "Y": { sum = sum + 4; break; } // Score of each letter added to running total in sum variable
				case "K": { sum = sum + 5; break; }
				case "J": case "X": { sum = sum + 8; break; }
				case "Q": case "Z": { sum = sum + 10; break; }  //In this situation break is equivilant to Exit Loop command
			}
		}
		return sum; // Returns the score calculated; always runs here
	}
	
	
	public Boolean passwordValidator(String password)
	{
		// 04 - Password Validator
		// Complete this method to validate that the String password
		// is a valid password
		// A password is valid if it is
		// - between 8 and 16 characters long (inclusive)
		// - made up of letters (upper or lower), numbers, and the following characters !£$%
		// - has at least one lower case letter, one upper case letter and a number
		// - does not contain the phrases 'password' or 'passwd'
		
		
		char character;
		
		Boolean length = false; // The conditions for failiure: Used as flags
		Boolean lowercase = false; //These flags begin as negative, the password will be valid if all tests are met and all the flags are changed
		Boolean uppercase = false;
		Boolean special = false;
		Boolean number = false;
		
		//Reminder for self: AND = &&, OR = ||
		
		//Special test
		if ((password.contains("password") || password.contains("passwd"))) // Must not contain either password or passwd
		{
			return false; // Automatic failure if condition matched: a password could possibly match all other conditions but contain one of these keywords
		}

		
		//Length test
		if (password.length() >= 8 && password.length() <= 16) // Must match 2 conditions of being greater/equal to 8 and less/equal to 16
		{ 
			length = true; // This flag is now true, must still match all other criteria
		}
		
		//Character test
		//Previously multiple tests, I have condensed the lowsercase, uppercase and illegal character tests as they all make use of loops
		//
		for (int i = 0; i < password.length(); i++) //Loops through each character, each character will be given all tests before moving on
		{
			character = password.charAt(i); // Lets the current character being tested be referred to as such 
			
			if (Character.isDigit(character)) // Previously switch statement: IsDigit automatically does the same for 0-9
			{ 
				number = true; // Will set to true if at least one number: future passes where IsDigit returns true will not change this
			}
			
			else if (Character.isLowerCase(character)) // Simple case checks using isLowerCase function
				// Else if used as this statement is not needed if we already know that character is a digit
			{ 
				lowercase = true; // Will set to true if at least one lowercase character: future passes where IsDigit returns true will not change this
			}
			else if (Character.isUpperCase(character)) // Simple case checks using isUpperCase function
				// Else if used as this statement is not needed if we already know that character is a digit or lower case
			{ 
				uppercase = true; // Will set to true if at least one uppercase character: future passes where IsDigit returns true will not change this
			}
			else if (!Character.isLetter(character)) // Previously v long switch statement, this function simply does the same and returns true for letters
				// Else if used as this statement is not needed if we already know that character is a digit or a letter (being either uppercase or lowercase)
			{
				switch(character) // No test remaining for this group of characters, so switch statement remains
				{
				case '!': case '£': case '$': case '%': special = true; break; //Exceptions for the valid special characters
				default: 
				{
						return false;
				}
				}
			}
		}

		
		// Tests for all booleans to be true, except special as it is not mandatory
		if ((length == true) && (lowercase == true) && (uppercase == true) && (number == true)) // Will only return true if every condition has been met
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
