package com.algorithms.queues.test;

import org.testng.Reporter;
import org.testng.TestException;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.algorithms.datastructures.queues.MaxPriorityQueue;
import com.algorithms.datastructures.queues.MinPriorityQueue;
import com.algorithms.datastructures.queues.Queue;
import com.algorithms.exceptions.CollectionOverflowException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.sorting.ShuffleArray;

public class TestQueue {

	private final Integer[] shuffledArrayWithDuplicatesInt;
	private final Character[] shuffledArrayWithDuplicatesChar;
	private Queue<Integer> testQueueInt;
	private Queue<Character> testQueueChar;
	private int seed;
	private long timeKeeper;

	public TestQueue() {

		seed = 1000000;

		shuffledArrayWithDuplicatesInt = ShuffleArray
				.knuthShuffleWithDuplicatesInt(seed);
		shuffledArrayWithDuplicatesChar = ShuffleArray
				.knuthShuffleWithDuplicatesChar(seed);
		testQueueInt = null;
		testQueueChar = null;
		timeKeeper = 0;

	}

	@BeforeTest
	@Test(groups = { "MaxHeapIntegers" })
	public void testMaxHeapIntPushPop() {

		Reporter.log("[ ** MaxHeap Integer Push ** ]\n");

		testQueueInt = new MaxPriorityQueue<>(new Integer[seed], true);

		try {

			Reporter.log("Insertion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueInt.push(shuffledArrayWithDuplicatesInt[i]);
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (CollectionOverflowException e) {
			throw new TestException("MaxHeap Insertion Failed!!!");
		}

		try {
			testQueueInt.push(1);
		} catch (CollectionOverflowException e) {
			Reporter.log("**Overflow Exception caught -- Passed.\n");
		}

		Reporter.log("[ ** MaxHeap Integer Pop ** ]\n");

		try {
			Reporter.log("Deletion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueInt.pop();
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (EmptyCollectionException e) {
			throw new TestException("MaxHeap Removal Failed!!!");
		}

		try {
			testQueueInt.pop();
		} catch (EmptyCollectionException e) {
			Reporter.log("**Empty Exception caught -- Passed.\n");
		}

	}

	@AfterGroups("MaxHeapIntegers")
	@Test(groups = { "MinHeapIntegers" })
	public void testMinHeapIntPushPop() {
		Reporter.log("[ ** MinHeap Integer Push ** ]\n");

		testQueueInt = new MinPriorityQueue<>(new Integer[seed], true);

		try {

			Reporter.log("Insertion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueInt.push(shuffledArrayWithDuplicatesInt[i]);
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (CollectionOverflowException e) {
			throw new TestException("MinHeap Insertion Failed!!!");
		}

		try {
			testQueueInt.push(1);
		} catch (CollectionOverflowException e) {
			Reporter.log("**Overflow Exception caught -- Passed.\n");
		}

		Reporter.log("[ ** MinHeap Integer Pop ** ]\n");

		try {

			Reporter.log("Deletion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueInt.pop();
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (EmptyCollectionException e) {
			throw new TestException("MinHeap Removal Failed!!!");
		}

		try {
			testQueueInt.pop();
		} catch (EmptyCollectionException e) {
			Reporter.log("**Empty Exception caught -- Passed.\n");
		}

	}

	@BeforeTest
	@Test(groups = { "MaxHeapCharacters" })
	public void testMaxHeapCharPushPop() {

		Reporter.log("[ ** MaxHeap Character Push ** ]\n");

		testQueueChar = new MaxPriorityQueue<>(new Character[seed], true);

		try {

			Reporter.log("Insertion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueChar.push(shuffledArrayWithDuplicatesChar[i]);
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (CollectionOverflowException e) {
			throw new TestException("MaxHeap Insertion Failed!!!");
		}

		try {
			testQueueChar.push('a');
		} catch (CollectionOverflowException e) {
			Reporter.log("**Overflow Exception caught -- Passed.\n");
		}

		Reporter.log("[ ** MaxHeap Character Pop ** ]\n");

		try {

			Reporter.log("Deletion : \n");
			timeKeeper = System.currentTimeMillis();

			for (int i = 0; i < seed; i++) {
				testQueueChar.pop();
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (EmptyCollectionException e) {
			throw new TestException("MaxHeap Removal Failed!!!");
		}

		try {
			testQueueChar.pop();
		} catch (EmptyCollectionException e) {
			Reporter.log("**Empty Exception caught -- Passed.\n");
		}
	}

	@AfterGroups({ "MaxHeapCharacters" })
	@Test(groups = { "MinHeapCharacters" })
	public void testMinHeapCharPushPop() {
		Reporter.log("[ ** MinHeap Character Push ** ]\n");

		testQueueChar = new MinPriorityQueue<>(new Character[seed], true);

		try {

			Reporter.log("Insertion : \n");
			timeKeeper = System.currentTimeMillis();

			for (Integer i = 0; i < seed; i++) {
				testQueueChar.push(shuffledArrayWithDuplicatesChar[i]);
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (CollectionOverflowException e) {
			throw new TestException("MinHeap Insertion Failed!!!");
		}

		try {
			testQueueChar.push('a');
		} catch (CollectionOverflowException e) {
			Reporter.log("**Overflow Exception caught -- Passed.\n");
		}

		Reporter.log("[ ** MinHeap Character Pop ** ]\n");
		try {

			Reporter.log("Deletion : \n");
			timeKeeper = System.currentTimeMillis();

			for (Integer i = 0; i < seed; i++) {
				testQueueChar.pop();
			}

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (EmptyCollectionException e) {
			throw new TestException("MinHeap Removal Failed!!!");
		}

		try {
			testQueueChar.pop();
		} catch (EmptyCollectionException e) {
			Reporter.log("**Empty Exception caught -- Passed.\n");
		}
	}
}
