package com.algorithms.datastructures.trees;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;

public interface Tree<Key extends Comparable<Key>, Value> {

    public void put(Key key, Value value) throws DuplicateKeyException;

    public void delete(Key key) throws KeyNotFoundException, EmptyCollectionException;

    public void printTree() throws EmptyCollectionException;

    public void deleteMax() throws EmptyCollectionException, KeyNotFoundException;

    public void deleteMin() throws EmptyCollectionException, KeyNotFoundException;

    public Value search(Key key) throws KeyNotFoundException, EmptyCollectionException;

    public void traverse();

    public boolean treeIsEmpty();

	/*
     * public void traversePreOrder();
	 * 
	 * public void traversePostOrder();
	 */

}
