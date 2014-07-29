package com.algorithms.datastructures.queues;

/**
 * Abstract Priority Queue or a Heap. The heap can be a MaxHeap or a MinHeap.
 * MaxHeap has all children less than or equal to the parent and a MinHeap has
 * all children greater than or equal to the parent.
 * 
 * Here I've chosen to represent k = [1, n] and shifted this when doing array
 * arithmetic. Below is the basic rule for such a Heap.
 * 
 * For the "k"th Node:
 * 
 * Parent's index = k/2
 * 
 * Children's index = 2k, 2k+1
 * 
 * @author sinsi02
 * @version 1.0
 * 
 * @param <E>
 */
public abstract class AbstractPriorityQueue<E extends Comparable<E>> {

	protected E[] array;
	protected long arrayAccess;
	protected long comparisions;
	protected int N;

	public AbstractPriorityQueue(E[] array) {
		this.array = array;
		this.N = array.length;
		this.arrayAccess = 0;
		this.comparisions = 0;
	}

	public AbstractPriorityQueue(E[] array, boolean empty) {
		this.array = array;
		this.arrayAccess = 0;
		this.comparisions = 0;

		if (empty) {
			this.N = 0;
		} else {
			this.N = array.length;
		}
	}

	/**
	 * Swim and sink differ slightly for MaxHeap and MinHeap in terms of
	 * comparisons.
	 * 
	 * @param k
	 */
	public abstract void swim(int k);

	public abstract void sink(int k);

	/**
	 * Resets the private array with the array passed.
	 * 
	 * @param array
	 */
	public void resetArray(E[] array) {
		this.array = array;
		this.N = this.array.length;
		this.arrayAccess = 0;
		this.comparisions = 0;
	}

	/**
	 * If the key of i is equal to the key of j, return true. i,j >= 1.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	public boolean isEqual(int i, int j) {
		assert i > 0 && j > 0;
		this.arrayAccess += 2;
		this.comparisions++;
		return this.array[i - 1].equals(this.array[j - 1]);
	}

	/**
	 * If the key of i is less than the key of j, return true. i,j >= 1.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	public boolean isLesser(int i, int j) {
		//E[] arrEs = new E[10];
		assert i > 0 && j > 0;
		this.arrayAccess += 2;
		this.comparisions++;
		if (this.array[i - 1].compareTo(this.array[j - 1]) < 0) {
			return true;
		} else
			return false;
	}

	/**
	 * If the key of i is greater than the key of j, return true. i,j >= 1.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	public boolean isGreater(int i, int j) {
		assert i > 0 && j > 0;
		if (this.array[i - 1].compareTo(this.array[j - 1]) > 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Swap array values. i,j >= 1.
	 * 
	 * @param i
	 *            The first index
	 * @param j
	 *            The second index
	 */
	public void swapArrayValues(int i, int j) {
		assert i > 0 && j > 0;

		E temp = array[i - 1];
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
	 * Returns the number of times any comparisons were made.
	 * 
	 * @return
	 */
	public long getComparisions() {
		return this.comparisions;
	}
}
