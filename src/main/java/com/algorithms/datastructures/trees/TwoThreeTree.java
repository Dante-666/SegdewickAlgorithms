package com.algorithms.datastructures.trees;

import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.KeyNotFoundException;

/**
 * This is a perfectly balanced tree. A few other examples are AVL trees and
 * Red-Black trees.
 * 
 * @author sinsi02
 * 
 * @param <Key>
 * @param <Value>
 */
public class TwoThreeTree<Key extends Comparable<Key>, Value> {

	private Node root;
	private static boolean caughtDuplicate = false;
	private static DuplicateKeyException tempDuplicateKeyException;

	/**
	 * This is the Node interface that has the basic methods that we can use
	 * during recursive calls. Since the Node is a nested class, we can easily
	 * create local variables and modify the internal private variables to
	 * modify the children.
	 * 
	 * @author sinsi02
	 * 
	 */
	public interface Node {
		public boolean is12Node();

		public boolean is23Node();

		public boolean is34Node();

		public boolean isLeafNode();

	}

	/**
	 * This is the Node which has 1 key and 2 children.
	 * 
	 * @author sinsi02
	 * 
	 */

	public class Node12 implements Node {
		private Key key1;
		private Value value1;

		private Node leftChild;
		private Node rightChild;

		public Node12(Key key, Value value) {
			this.key1 = key;
			this.value1 = value;
			this.leftChild = null;
			this.rightChild = null;
		}

		public boolean is12Node() {
			return true;
		}

		public boolean is23Node() {
			return false;
		}

		public boolean is34Node() {
			return false;
		}

		public boolean isLeafNode() {
			return this.leftChild == null && this.rightChild == null;
		}

		public String toString() {

			return key1.toString() + "/" + value1.toString();
		}

	}

	/**
	 * This is the Node which has 2 keys and 3 children.
	 * 
	 * @author sinsi02
	 * 
	 */
	public class Node23 implements Node {
		private Key key1;
		private Value value1;
		private Key key2;
		private Value value2;

		private Node leftChild;
		private Node middleChild;
		private Node rightChild;

		public Node23(Node12 node, Key key, Value value)
				throws DuplicateKeyException {
			int cmp = key.compareTo(node.key1);

			if (cmp < 0) {
				this.key1 = key;
				this.value1 = value;
				this.key2 = node.key1;
				this.value2 = node.value1;
			} else if (cmp > 0) {
				this.key1 = node.key1;
				this.value1 = node.value1;
				this.key2 = key;
				this.value2 = value;
			} else {
				throw new DuplicateKeyException();
			}

			this.leftChild = null;
			this.rightChild = null;
			this.middleChild = null;

		}

		public boolean is12Node() {
			return false;
		}

		public boolean is23Node() {
			return true;
		}

		public boolean is34Node() {
			return false;
		}

		public boolean isLeafNode() {
			return this.leftChild == null && this.rightChild == null
					&& this.middleChild == null;
		}

		public String toString() {

			return key1.toString() + "/" + value1.toString() + "|"
					+ key2.toString() + "/" + value2.toString();
		}

	}

	/**
	 * This is the Node which has 3 keys and 4 children. The Unstable Node.
	 * 
	 * @author sinsi02
	 * 
	 */
	public class Node34 implements Node {
		private Key key1;
		private Value value1;
		private Key key2;
		private Value value2;
		private Key key3;
		private Value value3;

		private Node leftChild;
		private Node quarterChild;
		private Node threeQuarterChild;
		private Node rightChild;

		public Node34(Node23 node, Key key, Value value)
				throws DuplicateKeyException {
			int cmp1 = key.compareTo(node.key1);
			int cmp2 = key.compareTo(node.key2);

			if (cmp1 < 0) {
				this.key1 = key;
				this.value1 = value;
				this.key2 = node.key1;
				this.value2 = node.value1;
				this.key3 = node.key2;
				this.value3 = node.value2;
			} else if (cmp2 > 0) {
				this.key1 = node.key1;
				this.value1 = node.value1;
				this.key2 = node.key2;
				this.value2 = node.value2;
				this.key3 = key;
				this.value3 = value;
			} else if (cmp1 == 0 || cmp2 == 0) {
				throw new DuplicateKeyException();
			} else {
				this.key1 = node.key1;
				this.value1 = node.value1;
				this.key2 = key;
				this.value2 = value;
				this.key3 = node.key2;
				this.value3 = node.value2;

			}

			this.leftChild = null;
			this.quarterChild = null;
			this.threeQuarterChild = null;
			this.rightChild = null;

		}

		public boolean is12Node() {
			return false;
		}

		public boolean is23Node() {
			return false;
		}

		public boolean is34Node() {
			return true;
		}

		/*
		 * public void split45Node(Node node, Node parent) {
		 * 
		 * }
		 */

		public boolean isLeafNode() {
			return this.leftChild == null && this.rightChild == null
					&& this.quarterChild == null
					&& this.threeQuarterChild == null;
		}

		public String toString() {

			return key1.toString() + "/" + value1.toString() + "|"
					+ key2.toString() + "/" + value2.toString() + "|"
					+ key3.toString() + "/" + value3.toString();
		}
	}

	public void put(Key key, Value value) throws DuplicateKeyException {

		caughtDuplicate = false;

		this.root = put(root, key, value);

		if (caughtDuplicate) {
			throw tempDuplicateKeyException;
		}

		if (this.root.is34Node()) {

			@SuppressWarnings("unchecked")
			Node34 tempNode34 = (Node34) this.root;
			Node12 newNode = new Node12(tempNode34.key2, tempNode34.value2);
			Node12 node1 = new Node12(tempNode34.key1, tempNode34.value1);
			Node12 node2 = new Node12(tempNode34.key3, tempNode34.value3);

			node1.leftChild = tempNode34.leftChild;
			node1.rightChild = tempNode34.quarterChild;

			node2.leftChild = tempNode34.threeQuarterChild;
			node2.rightChild = tempNode34.rightChild;

			newNode.leftChild = node1;
			newNode.rightChild = node2;

			this.root = newNode;
		}

	}

	@SuppressWarnings("unchecked")
	private Node put(Node currNode, Key key, Value value) {

		if (currNode == null) {
			return new Node12(key, value);
		}

		/**
		 * This is where we perform selective operations during the recursion
		 * using the local variables that are common to the stack. This replaces
		 * the LeafNodes with their upgraded versions and is later checked below
		 * for the invalid case.
		 * 
		 * This is where we search the appropriate position recursively and set
		 * the values for local variables for different stack calls.
		 */
		try {
			if (currNode.isLeafNode() && currNode != this.root) {

				if (currNode.is12Node()) {

					Node23 tempNode23 = new Node23((Node12) currNode, key,
							value);
					// currNode = null;
					currNode = tempNode23;

				} else if (currNode.is23Node()) {

					Node34 tempNode34 = new Node34((Node23) currNode, key,
							value);
					// currNode = null;
					currNode = tempNode34;
				}

				return currNode;

			} else if (currNode.is12Node()) {

				Node12 tempNode12 = (Node12) currNode;
				int cmp = key.compareTo(tempNode12.key1);

				if (cmp < 0) {
					tempNode12.leftChild = put(tempNode12.leftChild, key, value);

					if (tempNode12.leftChild.is34Node()) {

						Node34 childNode34 = (Node34) tempNode12.leftChild;
						Node12 node1 = new Node12(childNode34.key1,
								childNode34.value1);
						Node12 node2 = new Node12(childNode34.key3,
								childNode34.value3);

						if (!childNode34.isLeafNode()) {

							node1.leftChild = childNode34.leftChild;
							node1.rightChild = childNode34.quarterChild;

							node2.leftChild = childNode34.threeQuarterChild;
							node2.rightChild = childNode34.rightChild;
						}

						Node23 tempNode23 = new Node23(tempNode12,
								childNode34.key2, childNode34.value2);

						tempNode23.leftChild = node1;
						tempNode23.middleChild = node2;
						tempNode23.rightChild = tempNode12.rightChild;

						currNode = tempNode23;

						return currNode;

					}
					// put(tempNode.leftChild, key, value, tempNode);
				} else if (cmp > 0) {
					tempNode12.rightChild = put(tempNode12.rightChild, key,
							value);

					if (tempNode12.rightChild.is34Node()) {

						Node34 childNode34 = (Node34) tempNode12.rightChild;
						Node12 node1 = new Node12(childNode34.key1,
								childNode34.value1);
						Node12 node2 = new Node12(childNode34.key3,
								childNode34.value3);

						if (!childNode34.isLeafNode()) {

							node1.leftChild = childNode34.leftChild;
							node1.rightChild = childNode34.quarterChild;

							node2.leftChild = childNode34.threeQuarterChild;
							node2.rightChild = childNode34.rightChild;
						}

						Node23 tempNode23 = new Node23(tempNode12,
								childNode34.key2, childNode34.value2);

						tempNode23.leftChild = tempNode12.leftChild;
						tempNode23.middleChild = node1;
						tempNode23.rightChild = node2;

						currNode = tempNode23;

						return currNode;
					}
				} else {
					throw new DuplicateKeyException();
				}

			} else if (currNode.is23Node()) {
				Node23 tempNode23 = (Node23) currNode;
				int cmp1 = key.compareTo(tempNode23.key1);
				int cmp2 = key.compareTo(tempNode23.key2);

				if (cmp1 < 0) {
					tempNode23.leftChild = put(tempNode23.leftChild, key, value);

					if (tempNode23.leftChild.is34Node()) {

						Node34 childNode34 = (Node34) tempNode23.leftChild;
						Node12 node1 = new Node12(childNode34.key1,
								childNode34.value1);
						Node12 node2 = new Node12(childNode34.key3,
								childNode34.value3);

						if (!childNode34.isLeafNode()) {

							node1.leftChild = childNode34.leftChild;
							node1.rightChild = childNode34.quarterChild;

							node2.leftChild = childNode34.threeQuarterChild;
							node2.rightChild = childNode34.rightChild;
						}

						Node34 tempNode43 = new Node34(tempNode23,
								childNode34.key2, childNode34.value2);

						tempNode43.leftChild = node1;
						tempNode43.quarterChild = node2;
						tempNode43.threeQuarterChild = tempNode23.middleChild;
						tempNode43.rightChild = tempNode23.rightChild;

						currNode = tempNode43;

						return currNode;
					}

				} else if (cmp2 > 0) {
					tempNode23.rightChild = put(tempNode23.rightChild, key,
							value);

					if (tempNode23.rightChild.is34Node()) {

						Node34 childNode34 = (Node34) tempNode23.rightChild;
						Node12 node1 = new Node12(childNode34.key1,
								childNode34.value1);
						Node12 node2 = new Node12(childNode34.key3,
								childNode34.value3);

						if (!childNode34.isLeafNode()) {

							node1.leftChild = childNode34.leftChild;
							node1.rightChild = childNode34.quarterChild;

							node2.leftChild = childNode34.threeQuarterChild;
							node2.rightChild = childNode34.rightChild;
						}

						Node34 tempNode43 = new Node34(tempNode23,
								childNode34.key2, childNode34.value2);

						tempNode43.leftChild = tempNode23.leftChild;
						tempNode43.quarterChild = tempNode23.middleChild;
						tempNode43.threeQuarterChild = node1;
						tempNode43.rightChild = node2;

						currNode = tempNode43;

						return currNode;
					}
				} else if (cmp1 == 0 || cmp2 == 0) {
					 throw new DuplicateKeyException();
				} else if (cmp1 > 0 && cmp2 < 0) {
					tempNode23.middleChild = put(tempNode23.middleChild, key,
							value);

					if (tempNode23.middleChild.is34Node()) {

						Node34 childNode34 = (Node34) tempNode23.middleChild;
						Node12 node1 = new Node12(childNode34.key1,
								childNode34.value1);
						Node12 node2 = new Node12(childNode34.key3,
								childNode34.value3);

						if (!childNode34.isLeafNode()) {

							node1.leftChild = childNode34.leftChild;
							node1.rightChild = childNode34.quarterChild;

							node2.leftChild = childNode34.threeQuarterChild;
							node2.rightChild = childNode34.rightChild;
						}

						Node34 tempNode43 = new Node34(tempNode23,
								childNode34.key2, childNode34.value2);

						tempNode43.leftChild = tempNode23.leftChild;
						tempNode43.quarterChild = node1;
						tempNode43.threeQuarterChild = node2;
						tempNode43.rightChild = tempNode23.rightChild;

						currNode = tempNode43;

						return currNode;
					}
				}

			}
			/**
			 * We return the currentNode, In recursion, always think of when
			 * returning, what would be the case when you first made the call.
			 * 
			 */
			return currNode;
		} catch (DuplicateKeyException e) {
			tempDuplicateKeyException = e;
			caughtDuplicate = true;
			return currNode;
		}
	}

	public Value search(Key key) throws KeyNotFoundException {
		Value value = search(key, this.root);
		if (value == null) {
			throw new KeyNotFoundException();
		} else {
			return value;
		}
	}

	@SuppressWarnings("unchecked")
	private Value search(Key key, Node node) {

		Node xNode = node;

		while (xNode != null) {

			if (xNode.is12Node()) {

				Node12 tempNode12 = (Node12) xNode;
				int cmp = key.compareTo(tempNode12.key1);

				if (cmp < 0) {
					xNode = tempNode12.leftChild;
				} else if (cmp > 0) {
					xNode = tempNode12.rightChild;
				} else {
					return tempNode12.value1;
				}
			} else if (xNode.is23Node()) {
				Node23 tempNode23 = (Node23) xNode;

				int cmp1 = key.compareTo(tempNode23.key1);
				int cmp2 = key.compareTo(tempNode23.key2);

				if (cmp1 < 0) {
					xNode = tempNode23.leftChild;
				} else if (cmp2 > 0) {
					xNode = tempNode23.rightChild;
				} else if (cmp1 == 0) {
					return tempNode23.value1;
				} else if (cmp2 == 0) {
					return tempNode23.value2;
				} else {
					xNode = tempNode23.middleChild;
				}
			}
		}

		return null;
	}
}
