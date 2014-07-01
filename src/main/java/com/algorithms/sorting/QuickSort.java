package com.algorithms.sorting;

/**
 * The Quick sort algorithm works by recursively dividing the array based on a
 * pivot entry and placing every other element left or right of the pivot.
 * 
 * Time Complexity ::
 * 
 * Worst Case : O(n^2) | Best Case : O(n log n) | Average Case : O(n log n)
 * ----------------------------------------------------------------------------
 * 
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * 
 * Unstable : Since it switches elements that are far apart.
 * 
 * In-place : Since it requires O(1) auxiliary space.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

	private int limit;

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public QuickSort(T[] array) {
		super(array);
		limit = (int) (this.array.length * 0.0001);
		if (limit == 0)
			limit++;
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {
		this.arrayAccess = 0;
		this.comparisions = 0;

		this.quickSort(0, this.array.length - 1);
	}

	/**
	 * This is the recursive function that keeps 3 variables in the stack,
	 * namely, left, right and pivot. Based on these three, the array is sorted
	 * in chunks by passing the indices.
	 * 
	 * @param left
	 * @param right
	 */
	public void quickSort(int left, int right) {
		int pivot;
		/**
		 * Till the left and right positions cross over.
		 */
		if (right - left > limit) {
			/**
			 * The will part the array, more information is given below.
			 */
			pivot = this.partArray(left, right);
			this.quickSort(left, pivot);
			this.quickSort(pivot + 1, right);
		} else {
			/**
			 * Pass the array times it's length.
			 */
			for (int i = left; i <= right; i++) {
				/**
				 * Pass the array from the "i"th position to the end of the
				 * array just before the element 1. Now since we are comparing
				 * "j" with "j-1", we don't have to take it till 0 as evident in
				 * the below comments.
				 */
				for (int j = i; j > left; j--) {
					/**
					 * If the previous value is greater than the value at the
					 * present index, then shift these two.
					 * 
					 * We have to adapt such procedure since arrays are
					 * initialized as a block and if we try to find the
					 * appropriate place for the element and shift the whole of
					 * the array then, it would become a costly process.
					 * 
					 * Eventually, this constant swapping replicates the
					 * original behavior and thus maintains "Stability" too.
					 */
					if (isLesser(j, j - 1)) {
						this.swapArrayValues(j, j - 1);
						this.arrayAccess += 2;
						this.comparisions++;
					} else
						break;
				}

			}
		}

	}

	/**
	 * This partitions the array into two segments, a left part where all
	 * elements are less than a pivot value and the right part where all
	 * elements are greater.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public int partArray(int left, int right) {

		/*
		 * if (right - left == 1) { if (isLesser(left, right)) {
		 * this.swapArrayValues(left, right); } return right+1; }
		 */
		/**
		 * Start the count, since Java passes by reference only and these values
		 * are held in the stack, it is the only way.
		 */
		int leftIndex = left + 1;
		int rightIndex = right;

		/**
		 * This will pick a random value from the array and place it at the
		 * first position, so that it is easier to manipulate the indices.
		 */
		int pivotIndex = (int) (Math.random() * (right - left) + left);

		// int pivotIndex = (right + left) / 2;
		// T pivotValue = this.array[pivotIndex];
		this.arrayAccess++;

		/**
		 * Placing the pivot at the start.
		 */
		this.swapArrayValues(left, pivotIndex);

		while (true) {

			/**
			 * Till the leftIndex finds an element which is greater than the
			 * pivot, keep incrementing it.
			 */

			while (isLesser(leftIndex, left)) {
				/**
				 * If the leftIndex overflows, then stop immediately.
				 */
				if (leftIndex >= right)
					break;
				leftIndex++;

				this.arrayAccess++;
				this.comparisions++;
			}
			/**
			 * Till the rightIndex finds an element which is lesser than the
			 * pivot, keep decrementing it.
			 */
			while (isGreater(rightIndex, left) || isEqual(rightIndex, left)) {
				/**
				 * If the rightIndex overflows, then stop immediately.
				 */
				if (rightIndex <= left)
					break;
				rightIndex--;

				this.arrayAccess++;
				this.comparisions++;
			}
			/**
			 * After decrementing, just check if the indices have crossed. If
			 * so, then break out.
			 */
			if (leftIndex >= rightIndex) {
				break;
			}

			/**
			 * Swap when the leftIndex holds a bigger value and the rightIndex
			 * holds a smaller value relative to the pivot.
			 */
			// if (isLesser(rightIndex, leftIndex))
			this.swapArrayValues(leftIndex, rightIndex);
		}

		/**
		 * After the indices have crossed, just swap the pivot value in.
		 */
		this.swapArrayValues(left, rightIndex);

		/**
		 * The rightIndex will be the pivot for the recursive calls.
		 */
		return rightIndex;

	}

	/**
	 * Swap the values in the array.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void swapArrayValues(int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		this.arrayAccess += 4;
	}

}
