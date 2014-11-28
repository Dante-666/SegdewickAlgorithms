package com.algorithms.datastructures.queues;

import com.algorithms.exceptions.CollectionOverflowException;
import com.algorithms.exceptions.EmptyCollectionException;

/**
 * Order of growth :
 * <p/>
 * Unordered Array :
 * <p/>
 * Insert O(1) | Delete Maximum : O(n) | Get Max : O(n)
 * -----------------------------------------------------
 * <p/>
 * Ordered Array :
 * <p/>
 * Insert O(n) | Delete Maximum : O(1) | Get Max : O(1)
 * -----------------------------------------------------
 * <p/>
 * Binary Heap :
 * <p/>
 * Insert O(log n) | Delete Maximum : O(log n) | Get Max : O(1)
 * ------------------------------------------------------------
 *
 * @author Dante-666
 * @version 1.1
 */
public class MaxPriorityQueue<E extends Comparable<E>> extends
        AbstractPriorityQueue<E> implements Queue<E> {

    /**
     * The only constructor that initializes the array which represents the
     * heap.
     *
     * @param array The array to be sorted
     */
    public MaxPriorityQueue(E[] array) {
        super(array);

    }

    public MaxPriorityQueue(E[] array, boolean empty) {
        super(array, empty);
    }

    /**
     * Build a heap by taking in an unsorted array using the bottoms up method.
     */

    public void buildMaxHeap() {
        this.arrayAccess = 0;
        this.comparisions = 0;

        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
    }

    /**
     * In case the child somehow has a larger key than that of the parent, then
     * we replace the elements till the heap is restored. This is called a swim
     * operation since the element rather swims up. Swim should start at the
     * bottom.
     * <p/>
     * Peter's Principle : Promote till you can.
     *
     * @param k The child's index
     */
    public void swim(int k) {
        /**
         * Checking for isLesser makes sure that the >= property of MaxHeap is
         * satisfied.
         */
        while (k > 1 && isLesser(k / 2, k)) {
            swapArrayValues(k / 2, k);
            k = k / 2;
            this.arrayAccess += 2;
            this.comparisions++;
        }
    }

    /**
     * In case the parent somehow has a smaller key than that of the children,
     * then exchange the parent's key with the child having a larger key till
     * the heap is restored. This is called a sink operation since the element
     * sinks down to it's appropriate place. Sink should start from the root.
     * <p/>
     * Power Struggle : Better subordinate promoted.
     *
     * @param k The parent's index
     */
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && isLesser(j, j + 1))
                j++;
            if (isLesser(j, k))
                break;
            swapArrayValues(j, k);
            k = j;
            this.comparisions += 2;
        }

    }

    /**
     * Insert the element in the heap. This method uses the swim operation by
     * inserting an element at the end of the heap.
     *
     * @param element
     * @throws CollectionOverflowException
     */

    @Override
    public void push(E element) throws CollectionOverflowException {
        if (N >= array.length) {
            throw new CollectionOverflowException();
        }
        this.array[this.N++] = element;
        swim(N);

        this.arrayAccess++;
    }

    /**
     * Delete the largest value from the Heap. This removes the element from the
     * root which will be the largest while the heap is in order. Then replace
     * the last element from the list and sink it down to the appropriate place.
     *
     * @return Element that was popped which is the largest too.
     * @throws EmptyCollectionException
     */
    @Override
    public E pop() throws EmptyCollectionException {

        if (N == 0) {
            throw new EmptyCollectionException();
        }

        E max = this.array[0];
        this.array[0] = this.array[--this.N];
        this.sink(1);
        this.array[N] = null;

        this.arrayAccess += 4;
        return max;
    }

}