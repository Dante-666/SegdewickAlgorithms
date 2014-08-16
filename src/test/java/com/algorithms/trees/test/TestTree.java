package com.algorithms.trees.test;

import com.algorithms.datastructures.trees.AVLTree;
import com.algorithms.datastructures.trees.BinarySearchTree;
import com.algorithms.datastructures.trees.RandomBST;
import com.algorithms.datastructures.trees.RedBlackTree;
import com.algorithms.datastructures.trees.TwoThreeTree;
import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;
import com.algorithms.sorting.ShuffleArray;

import org.testng.Reporter;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTree {

	private Integer[] randomArray;
	private Character[] randomCharArray;
	private BinarySearchTree<Integer, Character> bTree = new BinarySearchTree<>();
	private RandomBST<Integer, Character> randomBST = new RandomBST<>();
	private TwoThreeTree<Integer, Character> b23Tree = new TwoThreeTree<>();
	private AVLTree<Integer, Character> avlTree = new AVLTree<>();
	private RedBlackTree<Integer, Character> redblackTree = new RedBlackTree<>();
	private int seed;
	private long timeKeeper;

	public TestTree() {

		seed = 1000000;
		randomArray = ShuffleArray.knuthShuffleNoDuplicatesInt(seed);
		randomCharArray = ShuffleArray.knuthShuffleWithDuplicatesChar(seed);
		timeKeeper = 0;

		// System.out.println("Running Tree Tests with Seed : " + seed);
	}

	@BeforeTest
	@Test(groups = { "BST", "Insertion" })
	public void testBSTInsertion() throws DuplicateKeyException {
		Integer count = 0;
		Reporter.log("[ ** BST Insertion ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (int i = 0; i < seed; i++) {
				bTree.put(randomArray[i], randomCharArray[i]);
			}

			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();

			for (Integer i = 0; i < seed; i++) {
				try {
					bTree.put(i, 'r');
				} catch (DuplicateKeyException e) {
					count++;
				}
			}

			if (count == seed) {
				Reporter.log("Fake Insert -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new DuplicateKeyException();
			}

		} catch (DuplicateKeyException e) {
			Reporter.log("Insertion -- Failed!!!\n");
			throw e;
		}

	}

	@BeforeTest
	@Test(groups = { "Random BST", "Insertion" })
	public void testRandomBSTInsertion() throws DuplicateKeyException {
		Integer count = 0;
		Reporter.log("[ ** Random BST Insertion ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (int i = 0; i < seed; i++) {
				randomBST.put(i, randomCharArray[i]);
			}

			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();

			for (Integer i = 0; i < seed; i++) {
				try {
					randomBST.put(i, 'r');
				} catch (DuplicateKeyException e) {
					count++;
				}
			}

			if (count == seed) {
				Reporter.log("Fake Insert -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new DuplicateKeyException();
			}

		} catch (DuplicateKeyException e) {
			Reporter.log("Insertion -- Failed!!!\n");
			throw e;
		}

	}

	@BeforeTest
	@Test(groups = { "Two-Three Tree", "Insertion" })
	public void test23TreeInsertion() throws DuplicateKeyException {
		Integer count;
		Reporter.log("[ ** 2-3 Tree Insertion ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				// System.out.println(i);
				b23Tree.put(randomArray[i], randomCharArray[i]);
			}
			// System.out.println("here");
			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = 0; i < seed; i++) {
				try {
					b23Tree.put(i, 'r');
				} catch (DuplicateKeyException e) {
					count++;
				}
			}

			if (count == seed) {
				Reporter.log("Fake Insert -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new DuplicateKeyException();
			}

		} catch (DuplicateKeyException e) {
			Reporter.log("Insertion -- Failed!!!\n");
			throw e;
		}

	}

	@BeforeTest
	@Test(groups = { "AVL Tree", "Insertion" })
	public void testAVLTreeInsertion() throws DuplicateKeyException {
		Integer count;
		Reporter.log("[ ** AVL Tree Insertion ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				avlTree.put(randomArray[i], randomCharArray[i]);
			}
			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = 0; i < seed; i++) {
				try {
					avlTree.put(i, 'r');
				} catch (DuplicateKeyException e) {
					count++;
				}
			}

			if (count == seed) {
				Reporter.log("Fake Insert -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new DuplicateKeyException();
			}

		} catch (DuplicateKeyException e) {
			Reporter.log("Insertion -- Failed!!!\n");
			throw e;
		}

	}

	@BeforeTest
	@Test(groups = { "Red Black Tree", "Insertion" })
	public void testRedBlackTreeInsertion() throws DuplicateKeyException {
		Integer count;
		Reporter.log("[ ** AVL Tree Insertion ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				// System.out.println(i);
				redblackTree.put(randomArray[i], randomCharArray[i]);
			}
			// System.out.println("here");
			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = 0; i < seed; i++) {
				try {
					redblackTree.put(i, 'r');
				} catch (DuplicateKeyException e) {
					count++;
				}
			}

			if (count == seed) {
				Reporter.log("Fake Insert -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new DuplicateKeyException();
			}

		} catch (DuplicateKeyException e) {
			Reporter.log("Insertion -- Failed!!!\n");
			throw e;
		}

	}

	@AfterGroups("Insertion")
	@Test(groups = { "BST", "Search" })
	public void testBSTSearch() throws KeyNotFoundException,
			EmptyCollectionException {

		Integer count = 0;

		Reporter.log("[ ** BST Search ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				bTree.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			for (Integer i = -seed; i < 0; i++) {
				try {
					bTree.search(i);
				} catch (KeyNotFoundException e) {
					count++;
				}
			}
			if (count == seed) {
				Reporter.log("False search -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new KeyNotFoundException();
			}
		} catch (KeyNotFoundException e) {
			Reporter.log("Searching -- Failed!!!\n");
			throw e;
		}

	}

	@AfterGroups("Insertion")
	@Test(groups = "Random BST")
	public void testRandomBSTSearch() throws KeyNotFoundException,
			EmptyCollectionException {

		Integer count = 0;

		Reporter.log("[ ** Random BST Search ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				randomBST.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			for (Integer i = -seed; i < 0; i++) {
				try {
					randomBST.search(i);
				} catch (KeyNotFoundException e) {
					count++;
				}
			}
			if (count == seed) {
				Reporter.log("False search -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new KeyNotFoundException();
			}
		} catch (KeyNotFoundException e) {
			Reporter.log("Searching -- Failed!!!\n");
			throw e;
		}

	}

	@AfterGroups("Insertion")
	@Test(groups = "Two-Three Tree")
	public void test23TreeSearch() throws KeyNotFoundException {

		Integer count;

		Reporter.log("[ ** 2-3 Tree Search ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				b23Tree.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = -seed; i < 0; i++) {
				try {
					b23Tree.search(i);
				} catch (KeyNotFoundException e) {
					count++;
				}
			}
			if (count == seed) {
				Reporter.log("False search -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new KeyNotFoundException();
			}
		} catch (KeyNotFoundException e) {
			Reporter.log("Searching -- Failed!!!\n");
			throw e;
		}

	}

	@AfterGroups("Insertion")
	@Test(groups = "AVL Tree")
	public void testAVLTreeSearch() throws KeyNotFoundException {

		Integer count;

		Reporter.log("[ ** 2-3 Tree Search ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				avlTree.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = -seed; i < 0; i++) {
				try {
					avlTree.search(i);
				} catch (KeyNotFoundException e) {
					count++;
				}
			}
			if (count == seed) {
				Reporter.log("False search -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new KeyNotFoundException();
			}
		} catch (KeyNotFoundException e) {
			Reporter.log("Searching -- Failed!!!\n");
			throw e;
		}

	}

	@AfterGroups("Insertion")
	@Test(groups = "Red Black Tree")
	public void testRedBlackTreeSearch() throws KeyNotFoundException,
			EmptyCollectionException {

		Integer count;

		Reporter.log("[ ** 2-3 Tree Search ** ]\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				redblackTree.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
			count = 0;

			for (Integer i = -seed; i < 0; i++) {
				try {
					redblackTree.search(i);
				} catch (KeyNotFoundException e) {
					count++;
				}
			}
			if (count == seed) {
				Reporter.log("False search -- Passed : "
						+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
			} else {
				throw new KeyNotFoundException();
			}
		} catch (KeyNotFoundException e) {
			Reporter.log("Searching -- Failed!!!\n");
			throw e;
		}

	}

	
	//TODO : Write a better skeleton for deletion and fix the empty collection exception.
	@AfterGroups({ "Insertion", "Search" })
	@Test(groups = "BST")
	public void testBSTDeletion() throws KeyNotFoundException,
			EmptyCollectionException {

		Reporter.log("[ ** BST Deletion ** ]\n");

		Integer count = 0;

		timeKeeper = System.currentTimeMillis();

		for (Integer i = -seed; i < 0; i++) {
			try {
				Reporter.log(i + "/n");
				bTree.delete(i);
			} catch (KeyNotFoundException e) {
				count++;
			}
		}

		if (count == seed) {
			Reporter.log("False deletion -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
		} else {
			throw new KeyNotFoundException();
		}

		timeKeeper = System.currentTimeMillis();

		for (Integer i = 0; i < seed; i++) {
			try {
				bTree.delete(i);
			} catch (KeyNotFoundException e) {
				Reporter.log("Deletion -- Failed!!!\n");
				throw e;
			}
		}

		try {
			bTree.delete(0);
		} catch (EmptyCollectionException e) {
			Reporter.log("Deletion -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

	}

	@AfterTest
	@Test(groups = "Deletion")
	public void testRandomBSTDeletion() throws KeyNotFoundException,
			EmptyCollectionException {

		Reporter.log("[ ** Random BST Deletion ** ]\n");

		Integer count = 0;

		timeKeeper = System.currentTimeMillis();

		for (Integer i = -seed; i < 0; i++) {
			try {
				randomBST.delete(i);
			} catch (KeyNotFoundException e) {
				count++;
			}
		}

		if (count == seed) {
			Reporter.log("False deletion -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
		} else {
			throw new KeyNotFoundException();
		}

		timeKeeper = System.currentTimeMillis();

		for (Integer i = 0; i < seed; i++) {
			try {
				randomBST.delete(i);
			} catch (KeyNotFoundException e) {
				Reporter.log("Deletion -- Failed!!!\n");
				throw e;
			}
		}

		try {
			randomBST.delete(0);
		} catch (EmptyCollectionException e) {
			Reporter.log("Deletion -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

	}

}
