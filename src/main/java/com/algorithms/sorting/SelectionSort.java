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

	    int arrLength=this.array.length;
	    int iMin;
		for (int i = 0; i < arrLength - 1; i++) {
		        iMin=i;
			for (int j = i+1; j < arrLength; j++) {
				if (array[j] < array[iMin]) {
					iMin=j;
				}
				this.arrayAccess += 2;
				this.comparisions++;
			}
			if(iMin!=i){
 			        this.swapArrayValues(i, iMin);
			}

		}
	}

	/**
	 * Swap the values.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void swapArrayValues(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j]=temp;

		this.arrayAccess += 2;
	}

}
