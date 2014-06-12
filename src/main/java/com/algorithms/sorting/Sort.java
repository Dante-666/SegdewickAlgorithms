package com.algorithms.sorting;

/**
 * This is the abstract class with basic methods and members required for any
 * type of Sorting.
 * 
 * @author sinsi02
 * @version 1.0
 */
public abstract class Sort {

	protected int[] array;
	protected long arrayAccess;
	protected long comparisions;

	public Sort(int[] array) {
		this.array = array;
		this.arrayAccess = 0;
		this.comparisions = 0;
	}

	/**
	 * Implement this method to acheive different types of sorting.
	 */
	public abstract void sortArray();

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

	public String toString() {
		String temp = "";

		for (int i = 0; i < this.array.length; i++) {
			temp += this.array[i] + " ";
		}

		temp += "\nArray Length: " + this.array.length
				+ "\nArray Comparisions: " + this.getComparisions()
				+ "\nArray Access: " + this.getArrayAccessCount();

		return temp;
	}

}
