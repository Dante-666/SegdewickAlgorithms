package com.algorithms.sorting;

/**
 * The Selection sort algorithm works by passing the array n times and inserting
 * the next element in an already sorted array.
 * <p/>
 * Time Complexity ::
 * <p/>
 * Worst Case : O(n^2) | Best Case : O(n^2) | Average Case : O(n^2)
 * ----------------------------------------------------------------
 * <p/>
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * <p/>
 * Performs worse than Insertion Sort but better than Bubble Sort.
 * <p/>
 * Unstable : Since it swaps values that might be far apart. Can be implemented
 * as a stable sort however if the whole of the array is shifted down instead of
 * just swapping the values, we will maintain the original order and hence
 * achieve stability.
 * <p/>
 * In-place : It only requires a constant amount O(1) of auxiliary space.
 *
 * @author Dante-666
 * @version 1.0
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public SelectionSort(T[] array) {
        super(array);
    }

    /**
     * The sorting method, sorts the private array.
     */
    public void sortArray() {

        this.arrayAccess = 0;
        this.comparisions = 0;

        int arrLength = this.array.length;
        /**
         * This denotes the index of the minimum element. It is assumed that the
         * first element during the iteration is the minimum and then the array
         * is scanned till the end to find a value that is smaller than that and
         * finally the current iteration's minimum is swapped into place which
         * is just before the last iteration's minimum. We can see that why this
         * is not "Online" and not "Stable".
         */
        int iMin;
        /**
         * Iterate through the array once. No need to look for the last element
         * since it will contain the largest number automatically.
         */
        for (int i = 0; i < arrLength - 1; i++) {
            /**
             * Assume the current index to be the index holding the minimum
             * value.
             */
            iMin = i;
            /**
             * Scan through the array starting from one element next to the
             * current index "i+1" till "arrLength-1". Check if the "j"th
             * element is lower than "iMin". If so, update "iMin".
             */
            for (int j = i + 1; j < arrLength; j++) {
                if (isLesser(j, iMin)) {
                    iMin = j;
                }
                this.arrayAccess += 2;
                this.comparisions++;
            }
            /**
             * If the index was not changed at all during the process, or if the
             * "i"th element itself was the local minimum, then there is no need
             * to swap. Else swap them.
             */
            if (iMin != i) {
                this.swapArrayValues(i, iMin);
            }

        }
    }

    /**
     * Swap the values.
     *
     * @param i The first index
     * @param j The second index
     */
    public void swapArrayValues(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        this.arrayAccess += 2;
    }

}
