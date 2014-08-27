package com.algorithms.datastructures.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;

public class RandomBST<Key extends Comparable<Key>, Value> implements
		Tree<Key, Value> {

	private Node root;

	private long seed;
	private Random random;

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

		public String toString() {
			return "[" + this.key.toString() + "/" + this.value.toString()
					+ "|" + this.count + "]";
		}

	}

	public RandomBST() {
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		return node == null ? 0 : node.count;
	}

	public double uniform() {
		return random.nextDouble();
	}

	public boolean bernoulli(double p) {
		if (!(p >= 0.0 && p <= 1.0))
			throw new IllegalArgumentException(
					"Probability must be between 0.0 and 1.0");
		return uniform() < p;
	}

	private Node rotateRight(Node x) {

		Node y = x.left;

		x.left = y.right;
		y.right = x;

		// x.count = 1 + size(x.left) + size(x.right);

		return y;

	}

	private Node rotateLeft(Node x) {

		Node y = x.right;

		x.right = y.left;
		y.left = x;

		// x.count = 1 + size(x.left) + size(x.right);

		return y;
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
	public void put(Key key, Value value) throws DuplicateKeyException {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) throws DuplicateKeyException {
		if (x == null)
			return new Node(key, value, 1);

		if (bernoulli(1.0 / (x.count + 1.0)))
			return putRoot(x, key, value);

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

	private Node putRoot(Node x, Key key, Value value)
			throws DuplicateKeyException {
		if (x == null)
			return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			throw new DuplicateKeyException();
		else if (cmp < 0) {
			x.left = putRoot(x.left, key, value);
			x = rotateRight(x);
		} else if (cmp > 0) {
			x.right = putRoot(x.right, key, value);
			x = rotateLeft(x);
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	@Override
	public void delete(Key key) throws EmptyCollectionException,
			KeyNotFoundException {

		if (treeIsEmpty())
			throw new EmptyCollectionException();

		root = delete(this.root, key);
	}

	private Node delete(Node node, Key key) throws KeyNotFoundException {

		if (node == null)
			throw new KeyNotFoundException();

		int cmp = key.compareTo(node.key);

		if (cmp == 0)
			return join(node.left, node.right);
		else if (cmp < 0)
			node.left = delete(node.left, key);
		else if (cmp > 0)
			node.right = delete(node.right, key);

		node.count--;

		return node;
	}

	private Node join(Node leftTree, Node rightTree) {

		if (leftTree == null)
			return rightTree;
		if (rightTree == null)
			return leftTree;

		if (bernoulli((double) leftTree.count
				/ (leftTree.count + rightTree.count))) {
			leftTree.right = join(leftTree.right, rightTree);
			leftTree.count = 1 + size(leftTree.left) + size(leftTree.right);
			return leftTree;
		} else {
			rightTree.left = join(leftTree, rightTree.left);
			rightTree.count = 1 + size(rightTree.left) + size(rightTree.right);
			return rightTree;
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
	public boolean treeIsEmpty() {
		return root == null;
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