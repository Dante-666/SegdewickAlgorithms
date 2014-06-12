package com.algorithms.sorting;

/**
 * The Shell sort algorithm works by passing the array n times and inserting the
 * next element in an already sorted array. It is a generalization of Shell sort
 * that allows the exchange of objects that are far off.
 * 
 * @author sinsi02
 * @version 1.0
 */
public class ShellSort extends Sort {

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public ShellSort(int[] array) {
		super(array);
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {

 	        int arrLength=this.array.length;
		int temp, inner, outer;
		for (int gap = arrLength/2; gap>0; gap/=2) {
		        for (inner = gap; inner < arrLength; inner++) {
			        temp=array[inner];
				this.arrayAccess++;
				for(outer = inner; outer>=gap && array[outer-gap] > temp; outer-=gap) {
 				        array[outer]=array[outer-gap];
					this.arrayAccess += 3;
					this.comparisions++;
				}
				array[outer]=temp;
			}

		}
	}
}
