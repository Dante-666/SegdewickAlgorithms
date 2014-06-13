package com.algorithms.sorting;

/**
 * The Insertion sort algorithm works by passing the array n times and inserting
 * the next element so that it maintains a sorted list from the starting
 * position.
 * 
 * Time Complexity ::
 * 
 * Worst Case : O(n^2) | Best Case : O(n) | Average Case : O(n^2)
 * ----------------------------------------------------------------
 * 
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * 
 * Stable : Doesn't change the relative order since it doesn't allow to switch
 * elements that are far apart.
 * 
 * In-place : It only requires a constant amount O(1) of auxiliary space.
 * 
 * Adaptive : This works when the array is substantially sorted where the time
 * complexity reduces to O(n+i) where "n" is the number of elements and "i" is
 * the number of inversions being performed.
 * 
 * More efficient than Bubble sort and Selection sort in the best case.
 * 
 * Online : Can sort a list as it receives it.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class InsertionSort extends Sort {
	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public InsertionSort(int[] array) {
		super(array);
	}

	/**
	 * The sorting method, sorts the private array. Details of the functionality
	 * is mentioned below.
	 */
	public void sortArray() {

		int arrLength = this.array.length;

		/**
		 * Pass the array times it's length.
		 */
		for (int i = 0; i < arrLength; i++) {
			/**
			 * Pass the array from the "i"th position to the end of the array
			 * just before the element 1. Now since we are comparing "j" with
			 * "j-1", we don't have to take it till 0 as evident in the below
			 * comments.
			 */
			for (int j = i; j > 0; j--) {
				/**
				 * If the previous value is greater than the value at the
				 * present index, then shift these two.
				 * 
				 * We have to adapt such procedure since arrays are initialized
				 * as a block and if we try to find the appropriate place for
				 * the element and shift the whole of the array then, it would
				 * become a costly process.
				 * 
				 * Eventually, this constant swapping replicates the original
				 * behavior and thus maintains "Stability" too.
				 */
				if (array[j] < array[j - 1]) {
					this.shiftAdjacentValues(j);
					this.arrayAccess += 2;
					this.comparisions++;
				} else
					break;
			}

		}
	}

	/**
	 * Shift adjacent values array. Swaps the "i"th element with the "i-1"th
	 * element.
	 * 
	 * @param i
	 *            The present index
	 * 
	 */
	public void shiftAdjacentValues(int i) {
		int temp = array[i];
		array[i] = array[i - 1];
		array[i - 1] = temp;
		this.arrayAccess += 4;
	}

}
