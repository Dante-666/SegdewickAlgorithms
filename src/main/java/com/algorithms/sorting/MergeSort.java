package com.algorithms.sorting;

/**
 * The Merge sort algorithm works by recursively dividing the array till the
 * left index is less than the right index and merges the two arrays based on
 * the order of the elements.
 * <p/>
 * Time Complexity ::
 * <p/>
 * Worst Case : O(n log n) | Best Case : O(n log n) | Average Case : O(n log n)
 * ----------------------------------------------------------------------------
 * <p/>
 * Worst Case Space complexity :: O(n) and O(n) auxiliary
 * ------------------------------------------------------
 * <p/>
 * Stable : Doesn't change the relative order since it doesn't allow to switch
 * elements that are far apart.
 * <p/>
 * Not In-place : Since it requires O(n) auxiliary space.
 *
 * @author Dante-666
 * @version 1.0
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    private T[] auxArray;

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public MergeSort(T[] array) {
        super(array);
        this.auxArray = array.clone();
    }

    /**
     * The sorting method, sorts the private array.
     */
    public void sortArray() {
        this.arrayAccess = 0;
        this.comparisions = 0;

        divideArray(0, this.array.length - 1);
    }

    /**
     * This is the recursive method that keeps dividing the array till they are
     * one element long and then merging the two of them based on three indices.
     * <p/>
     * The idea is to merge two sorted arrays into one. The merge operation is
     * the one that does the job and it takes three indices, a low, a middle and
     * a high. The middle index is nothing but (low+high)/2.
     */
    public void divideArray(int low, int high) {

        if (high > low) {
            divideArray(low, (low + high) / 2);
            divideArray((low + high) / 2 + 1, high);
            mergeArray(low, (low + high) / 2, high);
        }
    }

    /**
     * Merge the array by copying the whole sequence into an aux array. This is
     * the reason why merge sort is not "In Place" algorithm since it uses O(n)
     * auxiliary spaces. This way we achieve a "Stable" sort. In case of Quick
     * Sort, we don't use an extra array and that is why it becomes "Unstable".
     *
     * @param low    The first index
     * @param middle The middle index
     * @param high   The second index
     */
    public void mergeArray(int low, int middle, int high) {
        /**
         * Copying the whole set of values first.
         */

        for (int i = low; i <= high; i++) {
            this.auxArray[i] = this.array[i];
            this.arrayAccess += 2;
        }

        /**
         * Copying the indices for the left and the right sub-arrays which are
         * nothing but an indexed access of the auxiliary array. "primeIndex" is
         * the index for the main array which will take the merged values.
         */
        int leftIndex = low;
        int rightIndex = middle + 1;
        int primeIndex = low;

        /**
         * Now as long as there are values in the left or right arrays, just
         * keep the loop running.
         */
        while (true) {
            /**
             * Break as soon as one of them crosses over.
             */
            if (leftIndex > middle) {
                break;
            }
            if (rightIndex > high) {
                break;
            }

            /**
             * If the leftValue is <= rightValue, then put it in the primary
             * array.
             */
            if (isLesser(leftIndex, rightIndex)
                    || isEqual(leftIndex, rightIndex))

                this.array[primeIndex++] = this.auxArray[leftIndex++];

            else

                this.array[primeIndex++] = this.auxArray[rightIndex++];

            this.comparisions++;
            this.arrayAccess += 4;

        }
        while (leftIndex <= middle) {
            this.array[primeIndex++] = this.auxArray[leftIndex++];

            this.arrayAccess += 2;
        }
        while (rightIndex <= high) {
            this.array[primeIndex++] = this.auxArray[rightIndex++];

            this.arrayAccess += 2;
        }
    }

    /**
     * If the Type of i is less than the Type of j, return true. Overridden to
     * compare Auxiliary array values.
     *
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean isLesser(int i, int j) {
        if (this.auxArray[i].compareTo(this.auxArray[j]) < 0) {
            return true;
        } else
            return false;
    }

    /**
     * If the Type of i is equal to the Type of j, return true. Overridden to
     * compare Auxiliary array values.
     *
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean isEqual(int i, int j) {
        return this.auxArray[i].equals(this.auxArray[j]);
    }
}
