package com.algorithms.sorting;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * The Radix sort algorithm works when there are Integers in the array.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class RadixSort {

	private final Integer[] array;
	private Queue<Integer>[] queue;
	private long arrayAccess;
	private long comparisions;

	/**
	 * The only constructor that initializes the array and the queue.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	@SuppressWarnings("unchecked")
	public RadixSort(Integer[] array) {
		this.array = array;
		queue = (Queue<Integer>[]) new ArrayDeque[10];
		for (int i = 0; i < 10; i++)
			queue[i] = new ArrayDeque<>();
	}
	
	public boolean isSorted() {
		int length = this.array.length, i;
		length--;

		for (i = 0; i < length; i++) {
			if (this.array[i].compareTo(this.array[i + 1]) < 0
					|| this.array[i].equals(this.array[i + 1])) {
				continue;
			} else {
				break;
			}
		}

		if (i == length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {

		this.arrayAccess = 0;
		this.comparisions = 0;

		int divisor = 10;
		int max = 1;
		boolean maxSet = false;

		while (max / (divisor / 10) > 0) {

			for (Integer temp : array) {

				if (!maxSet) {
					if (temp > max)
						max = temp;
					this.comparisions++;
					this.arrayAccess += 2;
				}

				queue[(temp % divisor) / (divisor / 10)].add(temp);

				this.arrayAccess++;

			}

			if (maxSet == false)
				maxSet = true;

			divisor *= 10;

			int j = 0;

			for (int i = 0; i < 10; i++) {

				while (!queue[i].isEmpty()) {

					array[j] = queue[i].remove();
					j++;

				}
			}
			this.arrayAccess += 10;
		}
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
	 * Returns the number of times any comparisons were made.
	 * 
	 * @return
	 */
	public long getComparisions() {
		return this.comparisions;
	}

	public Integer[] getArray() {
		return this.array;
	}

	public String toString() {
		String temp = Arrays.toString(array);

		temp += "\nArray Length: " + this.array.length
				+ "\nArray Comparisions: " + this.getComparisions()
				+ "\nArray Access: " + this.getArrayAccessCount();

		return temp;
	}
}