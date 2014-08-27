package com.algorithms.debug;

import java.util.Iterator;

import com.algorithms.datastructures.trees.BinarySearchTree;
import com.algorithms.datastructures.trees.RandomBST;
import com.algorithms.datastructures.trees.RedBlackTree;
import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;
import com.algorithms.sorting.ShuffleArray;

/**
 * Created by dante on 8/9/14.
 */
public class Runner {
	public static void main(String[] args) throws DuplicateKeyException,
			KeyNotFoundException, EmptyCollectionException {

		BinarySearchTree<Integer, Character> btree = new BinarySearchTree<>();
		// Integer[] testInt = ShuffleArray.knuthShuffleNoDuplicatesInt(20);

		btree.put(4, 'a');
		btree.put(2, 'b');
		btree.put(7, 'f');	
		btree.put(1, 'd');
		btree.put(3, 'e');
		btree.put(6, 'c');
		btree.put(8, 'g');

		/*
		 * btree.put('a','a'); btree.put('b','a'); btree.put('c','a');
		 * //btree.printTree(); btree.put('d','a'); btree.put('e','a');
		 * btree.put('f','a'); //btree.printTree(); btree.put('g','a');
		 * btree.put('h','a'); btree.put('i','a'); //btree.printTree();
		 * btree.put('j','a'); btree.put('k','a'); btree.put('l','a');
		 * //btree.printTree(); btree.put('r','a'); btree.put('m','a');
		 * btree.put('n','a'); //btree.printTree(); btree.put('o','a');
		 * btree.put('p','a'); btree.put('q','a'); btree.printTree();
		 */

		btree.printTree();

		Iterator<Integer> myIterable = btree.inOrder();

		while (myIterable.hasNext()) {
			System.out.println(myIterable.next());
		}

		System.out.println("Success");

		// btree.printTree();

	}
}