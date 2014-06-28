package com.algorithms.datastructures.trees;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.KeyNotFoundException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public class Node {

		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

	}

	public void put(Key key, Value value) throws DuplicateKeyException {

		root = put(root, key, value);

	}

	private Node put(Node x, Key key, Value value) throws DuplicateKeyException {
		if (x == null)
			return new Node(key, value);

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = put(x.left, key, value);

		else if (cmp > 0)
			x.right = put(x.right, key, value);

		else
			throw new DuplicateKeyException();

		return x;

	}

	public Value search(Key key) throws KeyNotFoundException {
		Value value = search(key, this.root);
		if (value == null) {
			throw new KeyNotFoundException();
		} else {
			return value;
		}
	}

	private Value search(Key key, Node node) {
		Node xNode = node;

		while (xNode != null) {
			int cmp = key.compareTo(xNode.key);

			if (cmp < 0)
				xNode = xNode.left;
			else if (cmp > 0)
				xNode = xNode.right;
			else
				return xNode.value;

		}
		return null;
	}

	public void delete(Key key) {
		Node x = this.root;

		while (x != null) {
			int cmp = key.compareTo(x.key);

			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			// else
			// return x.value;
		}
	}

	/*
	 * public Iterable<Key> iterator() {
	 * 
	 * }
	 */

}
