package com.algorithms.datastructures.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;

public class AVLTree<Key extends Comparable<Key>, Value> implements
		Tree<Key, Value> {

	private Node root;

	public class Node {

		private Key key;
		private Value value;
		private Node left, right;
		private int height;

		public Node(Key key, Value value, int count) {
			this.key = key;
			this.value = value;
			this.height = count;
		}

		public String toString() {
			return "[" + this.key.toString() + "/" + this.value.toString()
					+ "/" + this.height + "]";
		}
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return 0;

		return node.height;
	}

	public void printTree() throws EmptyCollectionException {
		if (treeIsEmpty())
			throw new EmptyCollectionException();

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

		if (height(x.left) - height(x.right) > 1) {

			if (height(x.left.left) > height(x.left.right))
				return rotateRight(x);

			else if (height(x.left.right) > height(x.left.left))
				return rotateLeftRight(x);

		}
		// Left Rotation
		else if (height(x.right) - height(x.left) > 1) {

			if (height(x.right.right) > height(x.right.left))
				return rotateLeft(x);

			else if (height(x.right.left) > height(x.right.right))
				return rotateRightLeft(x);

		}

		x.height = 1 + Math.max(height(x.left), height(x.right));

		return x;

	}

	private Node rotateRight(Node x) {

		Node y = x.left;

		x.left = y.right;
		y.right = x;

		x.height = 1 + Math.max(height(x.left), height(x.right));

		// System.out.println("RotateRight");

		return y;

	}

	private Node rotateLeft(Node x) {

		Node y = x.right;

		x.right = y.left;
		y.left = x;

		x.height = 1 + Math.max(height(x.left), height(x.right));

		// System.out.println("RotateLeft");

		return y;
	}

	private Node rotateLeftRight(Node x) {

		Node y = x.left;
		Node z = y.right;

		y.right = z.left;
		z.left = y;

		x.left = z;

		y.height--;
		z.height++;
		// x.height = height(x.right) + 1;
		// System.out.print("RotateLeft-");

		return rotateRight(x);

	}

	private Node rotateRightLeft(Node x) {
		Node y = x.right;
		Node z = y.left;

		y.left = z.right;
		z.right = y;

		x.right = z;

		y.height--;
		z.height++;
		// x.height = 1 + Math.max(height(x.left), height(x.right));
		// System.out.print("RotateRight-");

		return rotateLeft(x);
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

	@Override
	public void deleteMax() throws EmptyCollectionException,
			KeyNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMin() throws EmptyCollectionException,
			KeyNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean treeIsEmpty() {
		return root == null;
	}
	
	public Iterator<Key> inOrder() {

		List<Key> inOrderList = new LinkedList<>();

		inOrder(root, inOrderList);

		return inOrderList.iterator();

	}

	public Iterator<Key> postOrder() {

		List<Key> postOrderList = new LinkedList<>();

		postOrder(root, postOrderList);

		return postOrderList.iterator();

	}
	
	public Iterator<Key> preOrder() {

		return new PreOrder();

	}

	private void inOrder(Node node, List<Key> inOrderList) {

		if (node == null)
			return;
		inOrder(node.left, inOrderList);
		inOrderList.add(node.key);
		inOrder(node.right, inOrderList);

	}

	private void postOrder(Node node, List<Key> inOrderList) {
		if (node == null)
			return;
		inOrder(node.left, inOrderList);
		inOrder(node.right, inOrderList);
		inOrderList.add(node.key);
	}
	
	private class PreOrder implements Iterator<Key> {

		Stack<Node> stack = new Stack<>();

		public PreOrder() {
			if (root != null)
				stack.push(root);
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Key next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node node = stack.pop();
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
			return node.key;
		}

		@Override
		public void remove() {
			// Do Nothing
		}
	}


	/*
	 * public Iterable<Key> iterator() {
	 * 
	 * }
	 */

}
