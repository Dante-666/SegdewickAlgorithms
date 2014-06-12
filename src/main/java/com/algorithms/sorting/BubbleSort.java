package com.algorithms.sorting;

/**
 * The Bubble sort algorithm works by passing the array n times and swapping
 * adjacent values if the value in the next index is less than the previous.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class BubbleSort extends Sort {

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public BubbleSort(int[] array) {
		super(array);
	}

	/**
	 * The sorting method, sorts the private array. Anytime if the (n+1)th
	 * element is less than the (n)th element, it will swap the values and move
	 * on.
	 */
	public void sortArray() {

		for (int i = this.array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				this.arrayAccess += 2;
				this.comparisions++;
				if (this.array[j + 1] < this.array[j]) {
					this.swapArrayValues(j + 1, j);
				}
			}

		}
	}

	/**
	 * Swaps the array values given the position.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void swapArrayValues(int i, int j) {
		int temp = this.array[i];

		this.array[i] = this.array[j];
		this.array[j] = temp;

		this.arrayAccess += 4;
	}
}
