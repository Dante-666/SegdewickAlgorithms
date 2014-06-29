package com.algorithms.datastructures.queues;

import com.algorithms.exceptions.CollectionOverflowException;
import com.algorithms.exceptions.EmptyCollectionException;

/**
 * This interface can be implemented to achieve elementary Queue operations in
 * FIFO manner.
 * 
 * @author sinsi02
 * @version 1.0
 * @param <E>
 */
public interface Queue<E> {

	public void push(E element) throws CollectionOverflowException;

	public E pop() throws EmptyCollectionException;

}
