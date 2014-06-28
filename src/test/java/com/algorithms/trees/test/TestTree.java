package com.algorithms.trees.test;

import com.algorithms.datastructures.trees.BinarySearchTree;
import com.algorithms.datastructures.trees.TwoThreeTree;
import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.KeyNotFoundException;
import com.algorithms.sorting.ShuffleArray;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTree {

	private BinarySearchTree<Integer, Character> bTree = new BinarySearchTree<>();
	private TwoThreeTree<Integer, Character> b23Tree = new TwoThreeTree<>();
	private int seed = 1000000;
	private long timeKeeper = 0;

	Integer[] randomArray = ShuffleArray.knuthShuffleNoDuplicatesInt(seed);
	Character[] randomCharArray = ShuffleArray
			.knuthShuffleWithDuplicatesChar(seed);

	@BeforeTest
	@Test(groups = "BST")
	public void testBSTInsertion() throws DuplicateKeyException {
		Integer count = 0;
		Reporter.log("Testing BST Insertion\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer temp : randomArray) {
				bTree.put(temp, randomCharArray[temp]);
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
	@Test(groups = "Two-Three Tree")
	public void test23TreeInsertion() throws DuplicateKeyException {
		Integer count = 0;
		Reporter.log("Testing 2-3 Tree Insertion\n");

		try {
			timeKeeper = System.currentTimeMillis();

			for (Integer temp : randomArray) {
				b23Tree.put(temp, randomCharArray[temp]);
			}
			Reporter.log("Insert -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
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

	@AfterTest
	@Test(groups = "BST")
	public void testBSTSearch() throws KeyNotFoundException {

		Integer count = 0;

		Reporter.log("Testing BST Search\n");

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

	@AfterTest
	@Test(groups = "Two-Three Tree")
	public void test23TreeSearch() throws KeyNotFoundException {

		Integer count = 0;

		Reporter.log("Testing 2-3 Tree Search\n");

		try {
			timeKeeper = System.currentTimeMillis();
			for (Integer i = 0; i < seed; i++) {
				b23Tree.search(i);
			}
			Reporter.log("Search -- Passed : "
					+ (System.currentTimeMillis() - timeKeeper) + " ms\n");

			timeKeeper = System.currentTimeMillis();
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
}
