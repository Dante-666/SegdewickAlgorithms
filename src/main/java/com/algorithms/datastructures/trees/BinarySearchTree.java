package com.algorithms.datastructures.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements
		Tree<Key, Value> {

	private Node root;

	protected class Node {

		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return "[" + this.key.toString() + "/" + this.value.toString()
					+ "]";
		}

	}

	@Override
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

	@Override
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

	@Override
	public Value search(Key key) throws KeyNotFoundException,
			EmptyCollectionException {
		if (treeIsEmpty())
			throw new EmptyCollectionException();
		return search(key, this.root);
	}

	private Value search(Key key, Node node) throws KeyNotFoundException {
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
		throw new KeyNotFoundException();
	}

	@Override
	public void delete(Key key) throws KeyNotFoundException,
			EmptyCollectionException {

		if (treeIsEmpty())
			throw new EmptyCollectionException();

		Node x = this.root;
		Node parent = x, temp;

		while (x != null) {
			int cmp = key.compareTo(x.key);

			temp = x;

			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else {
				if (isLeaf(x)) {
					if (parent.right != null && parent.right.equals(x))
						parent.right = null;
					else if (parent.left != null && parent.left.equals(x))
						parent.left = null;
					else if (parent.equals(x))
						root = null;

				} else if (x.left == null) {
					x.key = x.right.key;
					x.value = x.right.value;

					x.left = x.right.left;
					x.right = x.right.right;

				} else if (x.right == null) {
					x.key = x.left.key;
					x.value = x.left.value;

					x.right = x.left.right;
					x.left = x.left.left;

				} else {
					System.out.println(temp.toString());

					temp = temp.left;
					parent = x;

					while (temp.right != null) {
						temp = temp.right;
						if (parent.equals(x))
							parent = x.left;
						else
							parent = parent.right;
					}

					x.key = temp.key;
					x.value = temp.value;

					if (parent.equals(x))
						parent.left = null;
					else
						parent.right = null;

				}

				return;
			}
			parent = temp;
		}
		throw new KeyNotFoundException();
	}

	@Override
	public void deleteMax() throws EmptyCollectionException,
			KeyNotFoundException {
		if (treeIsEmpty())
			throw new EmptyCollectionException();

		Node x = root;

		while (x.right != null)
			x = x.right;

		delete(x.key);
	}

	@Override
	public void deleteMin() throws EmptyCollectionException,
			KeyNotFoundException {
		if (treeIsEmpty())
			throw new EmptyCollectionException();

		Node x = root;

		while (x.left != null)
			x = x.left;

		delete(x.key);
	}

	@Override
	public void traverse() {

	}

	@Override
	public boolean treeIsEmpty() {
		return root == null;
	}

	public boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
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

}
