package com.algorithms.sorting;

/**
 * Test Data generator, uses the Knuth Shuffling algorithm to shuffle an array
 * which is a very effective way of shuffling.
 * 
 * Time Complexity : O(n)
 * 
 * Also gives an array that is sorted in the reverse order and an array which is
 * already sorted.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class Shuffle {

	/**
	 * This method iterates the array once and performs the shuffling in linear
	 * time O(n) as visible in the code itself.
	 * 
	 * @param seed
	 * @return Shuffled Array
	 */
	public static int[] knuthShuffle(int seed) {

		int[] array = new int[seed];
		int rand;
		int temp;
		/**
		 * Initialize the array and put it in sorted order first.
		 */
		for (int i = 0; i < seed; i++) {
			array[i] = i;
		}
		/**
		 * Pass the array once and based on the current index "i", pick a random
		 * number "rand" between [0 - i] and swap the "ith" and the "randth"
		 * elements.
		 */
		for (int i = 1; i < seed; i++) {
			rand = (int) (Math.random() * (i));
			temp = array[i];
			array[i] = array[rand];
			array[rand] = temp;
		}
		return array;
	}

	/**
	 * This returns a sorted array.
	 * 
	 * @param seed
	 * @return
	 */
	public static int[] getSortedArray(int seed) {
		int[] array = new int[seed];

		for (int i = 0; i < seed; i++) {
			array[i] = i;
		}
		return array;
	}

	/**
	 * This returns an unsorted array.
	 * 
	 * @param seed
	 * @return
	 */
	public static int[] getReverseSortedArray(int seed) {
		int[] array = new int[seed];
		int j = 0;

		for (int i = seed - 1; i > -1; i--) {
			array[j] = i;
			j++;
		}
		return array;
	}

}
