package com.algorithms.sorting;

import com.algorithms.datastructures.MaxPriorityQueue;

/**
 * The Heap sort algorithm works by using a data structure called as a Binary
 * Heap or a Priority Queue.
 * 
 * 
 * 
 * @author sinsi02
 * @version 1.0
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

	private MaxPriorityQueue<T> heap;

	/**
	 * The only constructor that initializes the array which represents the
	 * heap.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public HeapSort(T[] array) {
		super(array);
		this.heap = new MaxPriorityQueue<T>(array.clone());
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {
		heap.buildMaxHeap();
		for (int i = this.array.length - 1; i >= 0; i--) {
			this.array[i] = this.heap.deleteLargest();
		}
		this.arrayAccess = heap.getArrayAccessCount();
		this.comparisions = heap.getComparisions();
	}
}
