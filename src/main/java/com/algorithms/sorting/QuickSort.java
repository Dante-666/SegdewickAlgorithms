package com.algorithms.sorting;

/**
 * The Quick sort algorithm works by recursively dividing the array based on a
 * pivot entry and placing every other element left or right of the pivot.
 * <p/>
 * Updated this with 3-way partitioning as suggested by Djikstra.
 * <p/>
 * Time Complexity ::
 * <p/>
 * Worst Case : O(n^2) | Best Case : O(n log n) | Average Case : O(n log n)
 * ----------------------------------------------------------------------------
 * <p/>
 * Worst Case Space complexity :: O(n) and O(1) auxiliary
 * ------------------------------------------------------
 * <p/>
 * Unstable : Since it switches elements that are far apart.
 * <p/>
 * In-place : Since it requires O(1) auxiliary space.
 *
 * @author Dante-666
 * @version 2.0
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public QuickSort(T[] array) {
        super(array);
    }

    /**
     * The sorting method, sorts the private array.
     */
    public void sortArray() {
        this.arrayAccess = 0;
        this.comparisions = 0;

        this.quickSort(0, this.array.length - 1);
    }

    /**
     * This is the recursive function that keeps 3 variables in the stack,
     * namely, left, right and pivot. Based on these three, the array is sorted
     * in chunks by passing the indices.
     *
     * @param left
     * @param right
     */
    public void quickSort(int left, int right) {
        if (right <= left)
            return;
        int lt = left, gt = right;

        int i = lt;

        int pivotIndex = (int) (Math.random() * (right - left)) + left;

        T pivot = this.array[pivotIndex];

        swapArrayValues(left, pivotIndex);

        while (i <= gt) {

            int cmp = this.array[i].compareTo(pivot);

            if (cmp < 0)
                swapArrayValues(lt++, i++);
            else if (cmp > 0)
                swapArrayValues(gt--, i);
            else
                i++;

        }

        quickSort(left, lt - 1);
        quickSort(gt + 1, right);

    }

    /**
     * Swap the values in the array.
     *
     * @param i The first index
     * @param j The second index
     */
    public void swapArrayValues(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        this.arrayAccess += 4;
    }

}
