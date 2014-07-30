package com.algorithms.datastructures.trees;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.KeyNotFoundException;

/**
 * Invariant:
 * 
 * No path from the root to the bottom contains two consecutive red links.
 * 
 * The number of black links on every such path is the same
 * 
 * Here we are using the LLRB, which shows close correspondence with the 2-3
 * Tree.
 * 
 * @author sinsi02
 * 
 * @param <Key>
 * @param <Value>
 */

public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public class Node {

		private Key key;
		private Value value;
		private Node left, right;
		private boolean color; // Color of the parent link

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.color = true;
		}

		public String toString() {
			return "[" + this.key.toString() + "/" + this.value.toString()
					+ "/" + (this.color ? "Red" : "Black") + "]";
		}

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

	private boolean isRedNode(Node node) {
		if (node == null)
			return false;
		else {
			return node.color;
		}
	}

	private void flipColors(Node node) {
		node.color = true;
		node.left.color = false;
		node.right.color = false;
	}

	private Node rotateLeft(Node node) {

		Node tempNode = node.right;
		node.right = tempNode.left;
		tempNode.left = node;

		tempNode.color = node.color;
		node.color = true;

		return tempNode;
	}

	private Node rotateRight(Node node) {

		Node tempNode = node.left;
		node.left = tempNode.right;
		tempNode.right = node;

		tempNode.color = node.color;
		node.color = true;

		return tempNode;
	}

	public void put(Key key, Value value) throws DuplicateKeyException {

		root = put(root, key, value);
		this.root.color = false;

	}

	private Node put(Node x, Key key, Value value) throws DuplicateKeyException {
		if (x == null)
			return new Node(key, value);
		
		if (isRedNode(x.right) && isRedNode(x.left))
			flipColors(x);

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			x.left = put(x.left, key, value);

		else if (cmp > 0)
			x.right = put(x.right, key, value);

		else
			throw new DuplicateKeyException();
		
		if (isRedNode(x.right) && !isRedNode(x.left))
			x = rotateLeft(x);

		if (isRedNode(x.left) && isRedNode(x.left.left))
			x = rotateRight(x);

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
