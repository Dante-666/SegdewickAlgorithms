package com.algorithms.sorting;

/**
 * The Insertion sort algorithm works by passing the array n times and inserting
 * the next element in an already sorted array.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class InsertionSort extends Sort{
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
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {

		for (int i = 0; i < this.array.length; i++) {
			for (int j = i; j > 0 ; j--) {
				if (array[j] < array[j-1]) {
					this.shiftAdjacentValues(j, j-1);
					this.arrayAccess+=2;
					this.comparisions++;
				}
				else
				        break;
			}

		}
	}

	/**
	 * Insert the appropriate value and shift the array.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The previous index
	 */
	public void shiftAdjacentValues(int i, int j) {
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
		this.arrayAccess+=4;
	}

}
