package com.algorithms.sorting;

/**
 * The Merge sort algorithm works by recursively dividing the array till the
 * left index is less than the right index and merges the two arrays based on
 * the order of the elements.
 * 
 * Time Complexity ::
 * 
 * Worst Case : O(n log n) | Best Case : O(n log n) | Average Case : O(n log n)
 * ----------------------------------------------------------------------------
 * 
 * Worst Case Space complexity :: O(n) and O(n) auxiliary
 * ------------------------------------------------------
 * 
 * Stable : Doesn't change the relative order since it doesn't allow to switch
 * elements that are far apart.
 * 
 * Not In-place : Since it requires O(n) auxiliary space.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class MergeSort extends Sort {

	private int[] auxArray;

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public MergeSort(int[] array) {
		super(array);
		this.auxArray = new int[this.array.length];
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {
		divideArray(0, this.array.length - 1);
	}

	/**
	 * This is the recursive method that keeps dividing the array till they are
	 * one element long and then merging the two of them based on three indices.
	 * 
	 * The idea is to merge two sorted arrays into one. The merge operation is
	 * the one that does the job and it takes three indices, a low, a middle and
	 * a high. The middle index is nothing but (low+high)/2.
	 */
	public void divideArray(int low, int high) {

		if (high > low) {
			divideArray(low, (low + high) / 2);
			divideArray((low + high) / 2 + 1, high);
			mergeArray(low, (low + high) / 2, high);

		}
	}

	/**
	 * Merge the array by copying the whole sequence into an aux array. This is
	 * the reason why merge sort is not "In Place" algorithm since it uses O(n)
	 * auxiliary spaces.
	 * 
	 * @param low
	 *            The first index
	 * @param middle
	 *            The middle index
	 * @param high
	 *            The second index
	 */
	public void mergeArray(int low, int middle, int high) {
		/**
		 * Copying the whole set of values first.
		 */
		for (int i = low; i <= high; i++) {
			this.auxArray[i] = this.array[i];
		}

		/**
		 * Copying the indices for the left and the right sub-arrays which are
		 * nothing but an indexed access of the auxiliary array. "primeIndex" is
		 * the index for the main array which will take the merged values.
		 */
		int leftIndex = low;
		int rightIndex = middle + 1;
		int primeIndex = low;

		/**
		 * Now as long as there are values in the left or right arrays, just
		 * keep the loop running.
		 */
		while (leftIndex <= middle && rightIndex <= high) {
			/**
			 * If the leftValue is <= rightValue, then put it in the
			 */
			if (this.auxArray[leftIndex] <= this.auxArray[rightIndex])

				this.array[primeIndex++] = this.auxArray[leftIndex++];

			else

				this.array[primeIndex++] = this.auxArray[rightIndex++];

		}
		while (leftIndex <= middle) {
			this.array[primeIndex] = this.auxArray[leftIndex];
			primeIndex++;
			leftIndex++;
		}
	}
}
