package com.algorithms.datastructures.trees;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.KeyNotFoundException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public class Node {

		private Key key;
		private Value value;
		private Node left, right;
		private int count;

		public Node(Key key, Value value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;

		return node.count;
	}
	
	public void printTree() {
		Node x = this.root;

		printTree(x.right, true, "");
		System.out.println(x.toString());
		printTree(x.left, false, "");
	}

	private void printTree(Node node, boolean isRight, String indent) {

		if (node == null) {
			return;
		}

		printTree(node.right, true, indent
				+ (isRight ? "        " : " |      "));

		System.out.print(indent);

		if (isRight) {
			System.out.print(" /----- ");
		} else {
			System.out.print(" \\----- ");
		}

		System.out.println(node.toString());
		printTree(node.left, false, indent
				+ (isRight ? " |      " : "        "));
	}

	/*
	 * public Node floor(Key key) {
	 * 
	 * }
	 */

	public void put(Key key, Value value) throws DuplicateKeyException {

		root = put(root, key, value);

	}

	private Node put(Node x, Key key, Value value) throws DuplicateKeyException {
		if (x == null)
			return new Node(key, value, 1);

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = put(x.left, key, value);

		else if (cmp > 0)
			x.right = put(x.right, key, value);

		else
			throw new DuplicateKeyException();

		x.count = 1 + size(x.left) + size(x.right);

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
