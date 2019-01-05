public class AssessmentPartThree {

	// The simplest form of encryption is the rotation cipher (also known as Caeser's Cipher)
	// An offset value is chosen to encrypt a message. Each letter is replaced by the
	// letter that that number of places away from it.
	// So if an offset value of 1 is chosen, each letter is replaced by the one after it
	// - so a becomes b, b becomes c, etc
	// If a value of -2 is chosen a becomes y, b becomes z and so on
	
	 public char enryptedCharacter(char theChar, int theOffset)
	 {
		 // 05 - encryptedCharacter
		 // Complete this method so that it returns the encrypted character for
		 // theChar when and offset of theOffset is used
		 // So if theChar='m' and theOffset is 3 the method will return 'p'
		 // Lower case characters remain lower case, upper case remain upper case
		 // Any other characters are returned unchanged
		 
		 char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		 // Alphabet for when calculating the offset, so the program knows what 5 letters forward is for example
		 
		 boolean upperChar; // Boolean storing the original case of the character
		 
		 
		 upperChar = Character.isUpperCase(theChar); // Sets to true if upper case
		 
		 theChar = Character.toLowerCase(theChar); // Sets the working value or theChar to lowercase regardless of original
		 
		 for(int i = 0; i < alphabet.length; i++) // Loops through alphabet
			 {
			 	if (theChar == alphabet[i]) // Finds theChar's match within the alphabet
			 	{
			 		theOffset = theOffset + i; // Adds the matching value in the alphabet to the original offset
			 	}
			 }
		  
			 	if (Character.isLetter(theChar)) // Validates theChar is a letter
			 	{
			 		if (theOffset < 0) // Checks for a negative offset
			 		{
			 			theOffset = theOffset + 26; // Turns the negative offset into its positive equivilant (eg -1 becomes +25 in an alphabet of 26)
			 		}
			 		if (theOffset > alphabet.length)  // Checks for an offset larger than the alphabet
			 		{
			 			theOffset = theOffset - 26; // Reduces the offset without changing the result
			 			
			 			if (theOffset > alphabet.length)  // Checks for an offset still larger than the alphabet
				 		{
				 			theOffset = theOffset - 26;
				 		}
			 			theChar = alphabet[theOffset]; // Finalises char after offset correction
			 		}
			 		else 
			 		{
			 			theChar = alphabet[theOffset]; // Finalises char if no offset correction needed
			 		}
			 	}
			 
			 	else 
			 	{
				 	return theChar; // Returns char as original if not a letter
			 	}
			 
			 	if (upperChar) // If the original was uppercase
			 	{
				 	theChar = Character.toUpperCase(theChar); // Changes the working value to upper case
			 	}
			 
			 	return theChar; // Fin
			 
			 }

			 
	 
	 
	 public String encryptedString(String theMessage, int theOffset)
	 {
		 // 06 - encryptedMessage
		 // Complete this method so that it uses encryptedCharacter to 
		 // return the encrypted version of theMessage using theOffset
		 
		 String s = ""; // The string to be used in output
		 
		 for (char letter : theMessage.toCharArray()) // Loops through the message via the toCharArray method allowing each character to be checked induvidually
			{
				letter = enryptedCharacter( letter, theOffset); // Encrypts the letter currently being looked at by the loop by running it through the encryptedCharacter function above
				s = s + letter; // Adds the encrypted character to the working string for output
			}
		 return s;
	 }	
}
