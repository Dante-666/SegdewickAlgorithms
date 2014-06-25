package com.algorithms.datastructures;

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
		public boolean is23Node();

		public boolean is34Node();

		public boolean is45Node();

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

		public boolean is23Node() {
			return true;
		}

		public boolean is34Node() {
			return false;
		}

		public boolean is45Node() {
			return false;
		}

		public boolean isLeafNode() {
			return this.leftChild == null && this.rightChild == null;
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

		public Node23(Node12 node, Key key, Value value) {
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
				// throw DuplicateKeyException
			}

			this.leftChild = null;
			this.rightChild = null;
			this.middleChild = null;

		}

		public boolean is23Node() {
			return false;
		}

		public boolean is34Node() {
			return true;
		}

		public boolean is45Node() {
			return false;
		}

		public boolean isLeafNode() {
			return this.leftChild == null && this.rightChild == null
					&& this.middleChild == null;
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

		public Node34(Node23 node, Key key, Value value) {
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
			} else if (cmp1 == 0) {
				// throw DuplicateKeyException
			} else if (cmp2 == 0) {
				// throw DuplicateKeyException
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

		public boolean is23Node() {
			return false;
		}

		public boolean is34Node() {
			return false;
		}

		public boolean is45Node() {
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

	}

	public void put(Key key, Value value) {
		this.root = put(root, key, value, root);
	}

	@SuppressWarnings("unchecked")
	private Node put(Node currNode, Key key, Value value, Node parent) {

		if (currNode == null) {
			return new Node12(key, value);
		}

		/**
		 * This is where we search the appropriate position recursively and set
		 * the values for local variables for different stack calls.
		 */

		if (currNode.is23Node()) {
			Node12 tempNode23 = (Node12) currNode;
			int cmp = key.compareTo(tempNode23.key1);

			if (cmp < 0) {
				currNode = put(tempNode23.leftChild, key, value, tempNode23);
				// put(tempNode.leftChild, key, value, tempNode);
			} else if (cmp > 0) {
				currNode = put(tempNode23.rightChild, key, value, tempNode23);
			} else {
				// throw DuplicateKeyException;
			}

		} else if (currNode.is34Node()) {
			Node23 tempNode34 = (Node23) currNode;
			int cmp1 = key.compareTo(tempNode34.key1);
			int cmp2 = key.compareTo(tempNode34.key2);

			if (cmp1 < 0) {
				currNode = put(tempNode34.leftChild, key, value, tempNode34);
			} else if (cmp2 > 0) {
				currNode = put(tempNode34.rightChild, key, value, tempNode34);
			} else if (cmp1 == 0) {
				// throw DuplicateKeyException;
			} else if (cmp2 == 0) {
				// throw DuplicateKeyException;
			} else if (cmp1 > 0 && cmp2 < 0) {
				currNode = put(tempNode34.middleChild, key, value, tempNode34);
			}

		}

		/**
		 * This is where we perform selective operations during the recursion
		 * using the local variables that are common to the stack. This replaces
		 * the LeafNodes with their upgraded versions and is later checked below
		 * for the invalid case.
		 */
		if (currNode.isLeafNode()) {

			if (currNode.is23Node()) {

				Node23 tempNode34 = new Node23((Node12) currNode, key, value);
				currNode = null;
				currNode = tempNode34;

			} else if (currNode.is34Node()) {

				Node34 tempNode45 = new Node34((Node23) currNode, key, value);
				currNode = null;
				currNode = tempNode45;
			}

		}

		/**
		 * This is where we check in the end if the Node was changed to be the
		 * Node45 invalid state and split it and reflect the proper changes in
		 * the parent so that recursion can work.
		 */
		if (currNode.is45Node()) {

			/**
			 * Cast then so that we can modify the members with ease. Always the
			 * Node45's left key and right key are required to make the shit
			 * happen.
			 */
			Node34 currNode45 = (Node34) currNode;
			Node12 node1 = new Node12(currNode45.key1, currNode45.value1);
			Node12 node2 = new Node12(currNode45.key3, currNode45.value3);
			/**
			 * If the node is not root.
			 */
			if (currNode != parent) {

				if (parent.is23Node()) {
					Node12 parentNode23 = (Node12) parent;
					Node23 tempNode34 = new Node23(parentNode23,
							currNode45.key2, currNode45.value2);
					if (parentNode23.rightChild == currNode) {

						tempNode34.leftChild = parentNode23.leftChild;
						tempNode34.middleChild = node1;
						tempNode34.rightChild = node2;

						parent = null;
						currNode = null;

						parent = tempNode34;

					} else if (parentNode23.leftChild == currNode) {
						tempNode34.leftChild = node1;
						tempNode34.middleChild = node2;
						tempNode34.rightChild = parentNode23.rightChild;

						parent = null;
						currNode = null;

						parent = tempNode34;
					}

				} else if (parent.is34Node()) {
					Node23 parentNode34 = (Node23) parent;
					Node34 tempNode45 = new Node34(parentNode34,
							currNode45.key2, currNode45.value2);
					if (parentNode34.rightChild == currNode) {

						tempNode45.leftChild = parentNode34.leftChild;
						tempNode45.quarterChild = parentNode34.middleChild;
						tempNode45.threeQuarterChild = node1;
						tempNode45.rightChild = node2;

						parent = null;
						currNode = null;

						parent = tempNode45;

					} else if (parentNode34.leftChild == currNode) {

					} else if (parentNode34.middleChild == currNode) {

					}

				}

			}
			/**
			 * Handle the case when the 45 Node is root.
			 */
			else {

				Node12 newRootNode23 = new Node12(currNode45.key2,
						currNode45.value2);

				newRootNode23.leftChild = node1;
				newRootNode23.rightChild = node2;

				node1.leftChild = currNode45.leftChild;
				node1.rightChild = currNode45.quarterChild;
				node2.leftChild = currNode45.threeQuarterChild;
				node2.rightChild = currNode45.rightChild;

				currNode = null;
				root = null;

				root = newRootNode23;
				parent = root;

			}

		}
		/**
		 * We return the parent since the currentNode usually gets modified or
		 * even destroyed, the calls ensure the the currNode from the last stack
		 * gets the parent of the next stacks. In the first call also, we pass
		 * root as the parent which is the only condition when they are equal
		 * and hence the parent will be returning root itself in the last call.
		 * 
		 */
		return parent;
	}
}

/*
 * public class Node23 { private Key key1; private Value value1;
 * 
 * private Key key2; private Value value2;
 * 
 * private boolean isTwoNode;
 * 
 * private Node23 parent; private Node23 leftChild; private Node23 rightChild;
 * private Node23 middleChild;
 *//**
 * For initializing 2-Node
 * 
 * @param key
 * @param value
 */
/*
 * public Node23(Key key, Value value) { this.isTwoNode = true; this.key1 = key;
 * this.value1 = value; }
 *//**
 * For initializing 3-Node
 * 
 * @param key1
 * @param value1
 * @param key2
 * @param value2
 */
/*
 * public Node23(Key key1, Value value1, Key key2, Value value2) { //
 * this.isTwoNode = true; this.key1 = key1; this.value1 = value1; this.key2 =
 * key2; this.value2 = value2; }
 * 
 * public boolean getIsTwoNode() { return isTwoNode; }
 * 
 * public void setIsTwoNode(boolean x) { this.isTwoNode = x; }
 * 
 * public boolean isLeafNode() { return this.leftChild == null &&
 * this.rightChild == null && this.middleChild == null; } }
 * 
 * public void put(Key key, Value value) { root = put(root, key, value); }
 * 
 * private Node23 put(Node23 node, Key key, Value value) {
 * 
 * if (node == null) {
 * 
 * return new Node23(key, value);
 * 
 * } else if (node.isLeafNode()) {
 * 
 * if (node.getIsTwoNode()) { int cmp = key.compareTo(node.key1);
 * 
 * if (cmp < 0) {
 * 
 * node.key2 = node.key1; node.value2 = node.value1;
 * 
 * node.key1 = key; node.value1 = value;
 * 
 * node.setIsTwoNode(false);
 * 
 * } else if (cmp < 0) {
 * 
 * node.key2 = key; node.value2 = value;
 * 
 * node.setIsTwoNode(false);
 * 
 * } else {
 * 
 * node.value1 = value;
 * 
 * }
 * 
 * } else {
 * 
 * } } else if (node.isTwoNode) {
 * 
 * int cmp = key.compareTo(node.key1);
 * 
 * if (cmp < 0) { node.leftChild = put(node.leftChild, key, value); } else if
 * (cmp > 0) { node.rightChild = put(node.rightChild, key, value); } else {
 * node.value1 = value; }
 * 
 * } else if (!node.isTwoNode) {
 * 
 * int cmp1 = key.compareTo(node.key1); int cmp2 = key.compareTo(node.key2);
 * 
 * if (cmp1 < 0) { node.leftChild = put(node.leftChild, key, value); } else if
 * (cmp2 > 0) { node.rightChild = put(node.rightChild, key, value); } else if
 * (cmp1 == 0) { node.value1 = value; } else if (cmp2 == 0) { node.value2 =
 * value; } else { node.middleChild = put(node.middleChild, key, value); } }
 * return node;
 * 
 * }
 * 
 * public Value search(Key key) {
 * 
 * Node23 x = this.root;
 * 
 * while (x != null) { if (x.isTwoNode) { int cmp = key.compareTo(x.key1);
 * 
 * if (cmp < 0) { x = x.leftChild; } else if (cmp > 0) { x = x.rightChild;
 * 
 * } else { return x.value1; } } else { int cmp1 = key.compareTo(x.key1); int
 * cmp2 = key.compareTo(x.key2);
 * 
 * if (cmp1 < 0) { x = x.leftChild; } else if (cmp2 > 0) { x = x.rightChild; }
 * else if (cmp1 == 0) { return x.value1; } else if (cmp2 == 0) { return
 * x.value2; } else { x = x.middleChild; } } } return null; }
 */
