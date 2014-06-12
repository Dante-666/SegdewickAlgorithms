package com.algorithms.sorting;

/**
 * The Insertion sort algorithm works by passing the array n times and inserting
 * the next element in an already sorted array.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class SelectionSort extends Sort {

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public SelectionSort(int[] array) {
		super(array);
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {

		for (int i = 0; i < this.array.length; i++) {
			for (int j = i; j > 0; j--) {
				/*
				 * this.arrayAccess += 2; this.comparisions++;
				 */
				if (array[i] < array[j]) {
					this.shiftArrayValues(i, j);
				}
				this.arrayAccess += 2;
				this.comparisions++;
			}

		}
	}

	/**
	 * Insert the appropriate value and shift the array.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void shiftArrayValues(int i, int j) {
		int temp = array[i];
		int k = j;

		while (j < i) {
			array[j + 1] = array[j];
			this.arrayAccess += 2;
			this.comparisions++;
		}

		array[k] = temp;

		this.arrayAccess += 2;
	}

}