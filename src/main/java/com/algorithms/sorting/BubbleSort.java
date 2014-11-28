package com.algorithms.sorting;

/**
 * The Bubble sort algorithm works by passing the array n times and swapping
 * adjacent values if the value in the next index is less than the previous.
 * <p/>
 * * Time Complexity ::
 * <p/>
 * Worst Case : O(n^2) | Best Case : O(n) | Average Case : O(n^2)
 * ----------------------------------------------------------------
 * <p/>
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * <p/>
 * Stable : Doesn't change the relative order since it doesn't allow to switch
 * elements that are far apart.
 * <p/>
 * In-place : It only requires a constant amount O(1) of auxiliary space.
 * <p/>
 * Poorest sorting mechanism, a few variants exists like the Cock-tail Sort that
 * works by moving the smallest and the largest elements to the extreme ends.
 *
 * @author Dante-666
 * @version 1.0
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public BubbleSort(T[] array) {
        super(array);
    }

    /**
     * The sorting method, sorts the private array. Anytime if the (n+1)th
     * element is less than the (n)th element, it will swap the values and move
     * on.
     */
    public void sortArray() {

        this.arrayAccess = 0;
        this.comparisions = 0;

        /**
         * Pass the array once. This time from the back so that the inner loop
         * works well.
         */
        for (int i = this.array.length - 1; i > 0; i--) {
            /**
             * The loop for the first iteration, moves the whole (array.length -
             * 1) locations and so on.
             */
            for (int j = 0; j < i; j++) {
                this.arrayAccess += 2;
                this.comparisions++;
                /**
                 * If the next value is greater than the current value, swap
                 * them. This will push the largest element in the last place
                 * and so on.
                 */
                if (isLesser(j + 1, j)) {
                    this.swapArrayValues(j + 1, j);
                }
            }

        }
    }

    /**
     * Swaps the array values given the position.
     *
     * @param i The first index
     * @param j The second index
     */
    public void swapArrayValues(int i, int j) {
        T temp = this.array[i];

        this.array[i] = this.array[j];
        this.array[j] = temp;

        this.arrayAccess += 4;
    }
}
