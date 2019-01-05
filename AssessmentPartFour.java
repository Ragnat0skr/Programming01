import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssessmentPartFour {
	
	List<String> morseCode = new ArrayList<String>();
	
	public int loadMorseFromFile(String filename)
	{
		
		File file = new File(filename); // creates a instance of a file 
		morseCode.clear(); // clears the contents of the array "morseCode
		
		Scanner sc = null; // creates a scanner called sc and assigns it a value of null
		try //creates a try block and attempts to run the code inside it
		{
			sc = new Scanner(file); //assigns the value of file to the scanner sc
		} catch (FileNotFoundException e) // if an exception is thrown from assigning the value of "file" to the scanner sc, 
		{
			// TODO Auto-generated catch block
			e.printStackTrace(); // if an exception is met, prints the stack trace of the instance ready for debugging
		}
		String lineFromFile; // creates a string called lineFromFile
		while (sc.hasNextLine())  //creates a while loop as long as sc has another line waiting
		{	
			lineFromFile = sc.nextLine(); // makes lineFromFile equal to the 
			morseCode.add(lineFromFile); //adds the value assigned to lineFromFile to the array morseCode
		}
		return morseCode.size(); //returns the size of the array string morseCode

		
		
	}
	
	public String translateMorse()
	{
		
		String output = "";
				String[][] MorseKey = 
					{
						{".-", "a"},
						{"-...", "b"},
						{"-.-.", "c"},
						{"-..", "d"},
						{".", "e"},
						{"..-.", "f"},
						{"--.", "g"},
						{"....", "h"},
						{"..", "i"},
						{".---", "j"},
						{"-.-", "k"},
						{".-..", "l"},
						{"--", "m"},
						{"-.", "n"},
						{"---", "o"},
						{".--.", "p"},
						{"--.-", "q"},
						{".-.", "r"},
						{"...", "s"},
						{"-", "t"},
						{"..-", "u"},
						{"...-", "v"},
						{".--", "w"},
						{"-..-", "x"},
						{"-.--", "y"},
						{"--..", "z"},
						{"/", " "}};
				
				for (String morse : morseCode) {
					for (int i = 0; i < MorseKey.length; i++) {
						if (morse.equals(MorseKey[i][0])) {
							output = output + MorseKey[i][1];
							break;
						}
					}
				}
				morseCode.clear();
				return output;

				
	}
	
	
	

}
