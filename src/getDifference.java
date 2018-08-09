package odometer;

import java.util.ArrayList;
import java.util.List;

public class GetDifferenceBwNumber {
	
	
	
	
	static int getDifference(int num1, int num2) {
		
		
		// Set<Integer> validNumbers = generateAllNumbers();
		
		
		ArrayList <Integer> validNumbers = generateAllNumbers();
		
		int index1 = validNumbers.indexOf(num1);
		int index2 = validNumbers.indexOf(num2);
		int size = validNumbers.size();
		
		if(index1 <= index2 )return index2-index1;
		return (size-index1+index2);
		
	}
