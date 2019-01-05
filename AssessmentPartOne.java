//Assessment Part 1
//Programming 01
//J Dive

public class AssessmentPartOne {

	public int biggestOfThree(int num1, int num2, int num3)
	{
		// 01 - A Gentle Start													~A Guest
		// Debug this method so it passes the unit test.						~A Guest
		// Add comments beside any changes you make								~A Guest
		
		if (num1>num2)   // Reversed sign so query reads from (num1<num2) to now (num1>num2)
		{
			if (num3>num1) // This and other uncommented lines remain the same
			{
				return num3;
			}
			else
			{
				return num1;
			}
		}
		else 
		{
			if (num3>num2)
			{
				return num3;						
			}
			else
			{
				return num2;  // Added semicolon to correctly end command
			}
		}
	}
	
	public int sumNumbersBetween(int start, int end)
	{
		// 02 - Adding Across A Range											~A Guest
		// Complete this method so that it adds together all					~A Guest
		// the integers between start and end, but not including 				~A Guest
		// start or end															~A Guest
		// This method should only deal with 0 and positive integers			~A Guest
		// This method should return -1 if it cannot calculate the result		~A Guest
		
		// You should comment your code explaining what each part does			~A Guest
		
		int sumOfSquares = 0; // I'm unsure as to why the variable name is this when there's no squares involved?
							  // Either way name doesn't impact output so I'll leave it for convenience
		
		
		// Conditions preventing calculations
		//  Either start or end is negative
		if (start < 0) // Tests for start being negative
		{
			sumOfSquares = -1;
			return sumOfSquares; // Ends the function with the output of -1, as value cannot be calculated
		}
		
		if (end < 0) // Tests for end being negative
		{
			sumOfSquares = -1;
			return sumOfSquares; // Ends the function with the output of -1, as value cannot be calculated
		}
		
		// If no numbers between start and end
		if (start == end - 1)
		{
			sumOfSquares = -1;
			return sumOfSquares;
		}
		
		//  Start > End
		
		if (start > end)
		{
			sumOfSquares = -1;
			return sumOfSquares; // Ends the function with the output of -1, as value cannot be calculated
		}
		
		else if (start == end) // There are no numbers between the start and end if equal, meaning -1 output is required
		{
			sumOfSquares = -1;
			return sumOfSquares; // Ends the function with output of -1
		}
		else //Runs if start < end, all other conditions specified by previous statements
		{
			for(int i=start + 1; i < end; i++) // Loops starting at start + 1 (the first value to be added) through until it reaches the end, where the loop ends before adding end to the total
			{  // This is what calculates the numbers between start and end: all else is deciding whether to run it
				sumOfSquares = sumOfSquares + i;
			}
		}
		
		return sumOfSquares; // Required so there is a return line that can always be accessed
							 // However this will never be reached as at least one of (start>end),(start==end) or the else of that will be true
							 // It only exists to keep the java debugger quiet
		
	}
	
}
