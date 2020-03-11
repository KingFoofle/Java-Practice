 	package practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice { 

	public static void main(String[] args) {
		Random random = new Random();
		
		List<Integer> grades = new ArrayList<>();
		
		// Fills the grades
		for (int i = 0; i < 100; i ++) {
			grades.add(i, random.nextInt(101));
		}
		
		grades = roundGrades(grades);
		
		// Exercise 2
		
		int[] candles = new int[random.nextInt(51) + 50];
		
		// Fills the candle arr
		for (int i = 0; i < candles.length; i ++) {
			candles[i] = random.nextInt(4);
		}
		
		int x = biggestNumberCount(candles);
		System.out.println("Count: " + x);
	}
	

	public static int biggestNumberCount(int[] ar) {
		// Returns the amount of times the biggest number appears in an array of ints
		int bigCount = 0;
		int biggestNum = 0;
		
		for (int number : ar) {
			if (number > biggestNum) {biggestNum = number; bigCount = 0;}
			if (number == biggestNum) {bigCount++;}
		}
		
		return bigCount;
	}

	public static List<Integer> roundGrades(List<Integer> grades){
		
		/*
		 * Rounds the grades of an array of integers by the following rules:
		 * 	1) Grade must be higher than 38
		 * 	2) If it is, check if the next multiple of 5 is less than 3 numbers away
		 * 	3) If so, round the number up and change the number in the index
		 */
		
		for (int i = 0; i < grades.size(); i++) {			
			grades.set(i, closestToFive(grades.get(i)));
		}
	
		return grades;
	}
	
	public static int closestToFive(int grade) {
		if (grade < 38) {return grade;}
		for (int i = 1; i < 3; i++) {
			// Multiple of 5
			if ((grade + i) % 5 == 0) {
				return grade + i;
			}
		}
		
		return grade;
	}

}
