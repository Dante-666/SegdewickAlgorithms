package com.algorithms.sorting;

/**
 * The Shell sort algorithm works by h-sorting the array. These h-sorting
 * continues till h is equal to 1 at which point it becomes the insertion sort.
 * 
 * Time Complexity ::
 * 
 * Worst Case : O(n^2) | Best Case : O(n log n) |
 * 
 * Average Case : Depends on the * gap sequence
 * -----------------------------------------------
 * 
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * 
 * Adaptive : It works well when the array is already sorted.
 * 
 * Unstable : Since it allows exchanging elements that are far apart like in
 * Quick Sort.
 * 
 * In-place : It only requires a constant amount O(1) of auxiliary space.
 * 
 * Average case famous gap sequences :
 * 
 * 1) N/2^k : O(n^2) : Given by Shell himself.
 * 
 * 2) 2^k +/- 1 : O(n^3/2) : Hibbard, Papernov & Stasevich
 * 
 * 3) (3^k - 1) / 2 (!>n/3) : Knuth
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

		int arrLength = this.array.length;
		int temp, inner, outer;
		/**
		 * Create the Gap sequences, in this I have followed the useless Gap
		 * sequence that was given by Shell which does not increase performance
		 * in the average case.
		 */
		for (int gap = arrLength / 2; gap > 0; gap /= 2) {
			/**
			 * After the Gap has been set, start the inner loop that will start
			 * from the set Gap value and increment by one. The loop inside will
			 * take care of comparing with respect to the gaps.
			 */
			for (inner = gap; inner < arrLength; inner++) {
				/**
				 * Store the current value in a temp variable.
				 */
				temp = array[inner];
				this.arrayAccess++;
				/**
				 * For each "inner"th element, check if the current index is
				 * greater than or equal to the gap, also check if the "inner"th
				 * element is smaller than the "outer-gap"th element. "outer"
				 * decrements by gap values.
				 * 
				 * Illustration:
				 * 
				 * 0 1 2 3 4 5 6 7 8 9
				 * 
				 * E E L M O X A S P R
				 * 
				 * Assume that the element A is where the current inner element
				 * is, the gap is 3 resulting in a 3-sorting and making M the
				 * initial "inner" count. In this case, we can see actually how
				 * this works.
				 * 
				 * Here initially as this loop starts, outer=6; inner=6; gap=3;
				 * temp="A";
				 * 
				 * The conditions are checked that outer>=gap, which will be
				 * true for the first case always and that the temp value is
				 * less than the value one gap [outer-gap] behind. If both the
				 * conditions are true, then the values are swapped.
				 * 
				 * So this will be the case after the first swap. Notice that
				 * temp is holding the value that is compared every time,
				 * array[outer] = array[outer - gap]; will not swap per se but
				 * rather copy from one location to another.
				 * 
				 * 0 1 2 3 4 5 6 7 8 9
				 * 
				 * E E L M O X M S P R
				 * 
				 * After this outer alone decrements by 3 and the loop variables
				 * are as follows : outer=3; inner=6; gap=3; temp="A";
				 * 
				 * As we can see that still the condition holds good again it is
				 * partially changed as above. So, the assignment will bring
				 * this change in the array.
				 * 
				 * 0 1 2 3 4 5 6 7 8 9
				 * 
				 * E E L E O X M S P R
				 * 
				 * After the element in the gap has been switched, the array
				 * breaks by failing the condition outer>=gap; and exits out of
				 * this loop. See ahead for the final operation. The "outer"
				 * index is pointing to the 0th element at this stage.
				 */
				for (outer = inner; outer >= gap && array[outer - gap] > temp; outer -= gap) {
					array[outer] = array[outer - gap];
					this.arrayAccess += 3;
					this.comparisions++;
				}
				/**
				 * Finally, the original value is assigned and the state of the
				 * array is
				 * 
				 * 0 1 2 3 4 5 6 7 8 9
				 * 
				 * A E L E O X M S P R
				 * 
				 * 0 3 6
				 * 
				 * A E M are in sorted order with h=3.
				 */
				array[outer] = temp;
			}

		}
	}
}
