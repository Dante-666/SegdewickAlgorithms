package com.algorithms.sorting;

import java.util.Arrays;

/**
 * This is the abstract class with basic methods and members required for any
 * type of Sorting.
 * 
 * @author sinsi02
 * @version 1.0
 */
public abstract class Sort<T extends Comparable<T>> {

	protected T[] array;
	protected long arrayAccess;
	protected long comparisions;

	public Sort(T[] array) {
		this.array = array;
		this.arrayAccess = 0;
		this.comparisions = 0;
	}

	/**
	 * Implement this method to achieve different types of sorting.
	 */
	public abstract void sortArray();

	/**
	 * Sets the array
	 */

	public void setArray(T[] array) {
		this.array = array;
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

	/**
	 * Returns the array.
	 * 
	 * @return
	 */
	public T[] getArray() {
		return this.array;
	}

	/**
	 * If the Type of i is less than the Type of j, return true.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	public boolean isLesser(int i, int j) {
		if (this.array[i].compareTo(this.array[j]) < 0) {
			return true;
		} else
			return false;
	}

	/**
	 * If the Type of i is equal to the Type of j, return true.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	public boolean isEqual(int i, int j) {
		return this.array[i].equals(this.array[j]);
	}

	/**
	 * If the Type of i is greater than the Type of j, return true.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isGreater(int i, int j) {
		if (this.array[i].compareTo(this.array[j]) > 0) {
			return true;
		} else
			return false;
	}

	public String toString() {
		String temp = Arrays.toString(array);

		temp += "\nArray Length: " + this.array.length
				+ "\nArray Comparisions: " + this.getComparisions()
				+ "\nArray Access: " + this.getArrayAccessCount();

		return temp;
	}

}
