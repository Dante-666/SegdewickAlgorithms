package com.algorithms.sorting;

/**
 * The Quick sort algorithm works by recursively dividing the array based on a
 * pivot entry and placing every other element left or right of the pivot.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class QuickSort extends Sort {

    private int pivot;

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public QuickSort(int[] array) {
		super(array);
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {
	    this.quickSort(0, this.array.length);
	}
    
    public quickSort(int left, int right){
	this.pivot=this.partArray(left, right);
	this.quickSort(left,pivot);
	this.quickSort(pivot+1,left);
	
    }
    
    public partArray(int left, int right){
	
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
