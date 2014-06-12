package com.algorithms.sorting;

/**
 * Test Data generator, uses a basic randomization algorithm to sort an array.
 * Also gives an array that is sorted in the reverse order and an array which is already sorted.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class Shuffle {

	public static int[] getRandomUnsortedData(int seed) {

		int[] array = new int[seed];
		int rand;
		int temp;
		for (int i = 0; i < seed; i++) {
			array[i] = i;
		}
		for (int i = 0; i < seed; i++) {
			rand = (int) (Math.random() * (seed - 1));
			//System.out.println(rand);
			temp = array[i];
			array[i] = array[rand];
			array[rand] = temp;
		}
		return array;
	}

	public static int[] getSortedArray(int seed) {
		int[] array = new int[seed];

		for (int i = 0; i < seed; i++) {
			array[i] = i;
		}
		return array;
	}
	
	public static int[] getReverseSortedArray(int seed) {
		int[] array = new int[seed];
		int j=0;

		for (int i = seed-1; i >-1; i--) {
			array[j] = i;
			j++;
		}
		return array;
	}
	

}
