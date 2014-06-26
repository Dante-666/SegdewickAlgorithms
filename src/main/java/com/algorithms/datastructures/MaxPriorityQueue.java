package com.algorithms.datastructures;

/**
 * Order of growth :
 * 
 * Unordered Array :
 * 
 * Insert O(1) | Delete Maximum : O(n) | Get Max : O(n)
 * -----------------------------------------------------
 * 
 * Ordered Array :
 * 
 * Insert O(n) | Delete Maximum : O(1) | Get Max : O(1)
 * -----------------------------------------------------
 * 
 * Binary Heap :
 * 
 * Insert O(log n) | Delete Maximum : O(log n) | Get Max : O(1)
 * -----------------------------------------------------
 * 
 * 
 * @author sinsi02
 * @version 1.0
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

	/**
	 * The variable to keep the count of the total number of elements in the
	 * heap.
	 */
	private int N;
	private final T[] array;
	private int arrayAccess;
	private int comparisions;

	/**
	 * The only constructor that initializes the array which represents the
	 * heap.
	 * 
	 * Here the "0"th index is kept empty so that we can do arithmetic with the
	 * array and access the array in a heap fashion. Below is the rule.
	 * 
	 * For the "k"th Node:
	 * 
	 * Parent's index = k/2
	 * 
	 * Children's index = 2k, 2k+1
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public MaxPriorityQueue(T[] array) {
		this.array = array;
		this.N = this.array.length;
		this.arrayAccess = 0;
		this.comparisions = 0;

	}

	/*
	 * public MaxPriorityQueue(int seed) { this.array = new T[seed]; this.N = 0;
	 * this.arrayAccess = 0; this.comparisions = 0;
	 * 
	 * }
	 */

	/**
	 * Build a heap by taking in an unsorted array using the bottoms up method.
	 */

	public void buildMaxHeap() {
		this.arrayAccess = 0;
		this.comparisions = 0;
		
		for (int k = N / 2; k >= 1; k--) {
			sink(k);
		}
	}

	/**
	 * Insert the element in the heap. This method uses the swim operation by
	 * inserting an element at the end of the heap.
	 */
	public void insertElement(T key) {
		this.array[this.N++] = key;
		swim(N);

		this.arrayAccess++;
	}

	/**
	 * Delete the largest value from the Heap. This removes the element from the
	 * root which will be the largest while the heap is in order. Then replace
	 * the last element from the list and sink it down to the appropriate place.
	 */
	public T deleteLargest() {
		T max = this.array[0];
		this.array[0] = this.array[--this.N];
		this.sink(1);
		this.array[N] = null;

		this.arrayAccess += 4;
		return max;
	}

	/**
	 * In case the child somehow has a larger key than that of the parent, then
	 * we replace the elements till the heap is restored. This is called a swim
	 * operation since the element rather swims up.
	 * 
	 * Peter's Principle : Promote till you can.
	 * 
	 * @param k
	 *            The child's index
	 */
	public void swim(int k) {
		while (k > 1 && isLesser((k - 1) / 2, k - 1)) {
			swapArrayValues(k, k / 2);
			k = k / 2;
			this.arrayAccess += 2;
			this.comparisions++;
		}
	}

	/**
	 * In case the parent somehow has a smaller key than that of the children,
	 * then exchange the parent's key with the child having a larger key till
	 * the heap is restored. This is called a sink operation since the element
	 * sinks down to it's appropriate place.
	 * 
	 * Power Struggle : Better subordinate promoted.
	 * 
	 * @param k
	 *            The parent's index
	 */
	public void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;

			if (j < N && isLesser(j - 1, j))
				j++;
			if (isLesser(j - 1, k - 1))
				break;
			swapArrayValues(k, j);
			k = j;
			this.comparisions += 2;
		}

	}

	/**
	 * If the key of i is less than the key of j, return true.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	private boolean isLesser(int i, int j) {
		this.arrayAccess+=2;
		this.comparisions++;
		if (this.array[i].compareTo(this.array[j]) < 0) {
			return true;
		} else
			return false;
	}

	/**
	 * If the key of i is greater than the key of j, return true.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

/*	private boolean isGreater(int i, int j) {
		if (this.array[i].compareTo(this.array[j]) > 0) {
			return true;
		} else
			return false;
	}*/

	/**
	 * Swap array values.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void swapArrayValues(int i, int j) {
		T temp = array[i - 1];
		this.array[i - 1] = array[j - 1];
		this.array[j - 1] = temp;

		this.arrayAccess += 4;
	}

	/**
	 * Returns the number of times the array was accessed.
	 * 
	 * @return
	 */
	public long getArrayAccessCount() {
		return this.arrayAccess;
	}

	/**
	 * Returns the number of times any comparisions were made.
	 * 
	 * @return
	 */
	public long getComparisions() {
		return this.comparisions;
	}

}