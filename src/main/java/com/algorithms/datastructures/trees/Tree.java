package com.algorithms.datastructures.trees;

public interface Tree<Key extends Comparable<Key>, Value> {

	public void put(Key key, Value value);

	public void delete(Key key);

	public Value search(Key key);

	public void traverse();

	/*
	 * public void traversePreOrder();
	 * 
	 * public void traversePostOrder();
	 */

}
