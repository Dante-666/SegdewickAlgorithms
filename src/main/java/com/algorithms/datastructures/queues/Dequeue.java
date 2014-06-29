package com.algorithms.datastructures.queues;

public interface Dequeue<E extends Iterable<E>> extends Queue<E> {

	public void pushFirst(E element);

	public E popFirst();

	public void pushLast(E element);

	public E popLast();
}
