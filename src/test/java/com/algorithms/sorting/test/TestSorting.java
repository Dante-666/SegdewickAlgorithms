package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;
import com.algorithms.sorting.HeapSort;
import com.algorithms.sorting.InsertionSort;
import com.algorithms.sorting.RadixSort;
import com.algorithms.sorting.SelectionSort;
import com.algorithms.sorting.ShellSort;
import com.algorithms.sorting.MergeSort;
import com.algorithms.sorting.QuickSort;
import com.algorithms.sorting.ShuffleArray;
import com.algorithms.sorting.Sort;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.TestException;

@Test(groups = "Sorting")
public class TestSorting {

	private final Integer[] fastShuffledArrayInt;
	private final Character[] fastShuffledArrayChar;
	private final Integer[] primitiveShuffledArrayInt;
	private final Character[] primitiveShuffledArrayChar;
	private Sort<Integer> testSortIntegers;
	private Sort<Character> testSortCharacters;
	private int fastSeed;
	private int primitiveSeed;
	private long timeKeeper;

	public TestSorting() {

		fastSeed = 1000000;
		primitiveSeed = 10000;
		fastShuffledArrayInt = ShuffleArray
				.knuthShuffleWithDuplicatesInt(fastSeed);
		fastShuffledArrayChar = ShuffleArray
				.knuthShuffleWithDuplicatesChar(fastSeed);
		primitiveShuffledArrayInt = ShuffleArray
				.knuthShuffleWithDuplicatesInt(primitiveSeed);
		primitiveShuffledArrayChar = ShuffleArray
				.knuthShuffleWithDuplicatesChar(primitiveSeed);
		testSortIntegers = null;
		testSortCharacters = null;
		timeKeeper = 0;

	}

	@BeforeMethod
	@Test(groups = { "Integer-Sorting", "Primitive Sort" })
	public void testBubbleSortInt() {

		Reporter.log("[ ** Bubble Sort ** ]\n");

		try {
			testSortIntegers = new BubbleSort<>(
					primitiveShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Primitive Sort" })
	public void testSelectionSortInt() {

		Reporter.log("[ ** Selection Sort ** ]\n");
		try {
			testSortIntegers = new SelectionSort<>(
					primitiveShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Fast Sort" })
	public void testShellSortInt() {

		Reporter.log("[ ** Shell Sort ** ]\n");
		try {
			testSortIntegers = new ShellSort<>(
					fastShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Primitive Sort" })
	public void testInsertionSortInt() {

		Reporter.log("[ ** Insertion Sort ** ]\n");
		try {
			testSortIntegers = new InsertionSort<>(
					primitiveShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (Exception x) {
			System.err.println(x);
			throw x;
		}
	}

	@Test(groups = { "Integer-Sorting", "Fast Sort" })
	public void testMergeSortInt() {

		Reporter.log("[ ** Merge Sort ** ]\n");
		try {
			testSortIntegers = new MergeSort<>(
					fastShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Fast Sort" })
	public void testQuickSortInt() {

		Reporter.log("[ ** Quick Sort ** ]\n");

		try {
			testSortIntegers = new QuickSort<>(
					fastShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Fast Sort" })
	public void testHeapSortInt() {

		Reporter.log("[ ** Heap Sort ** ]\n");

		try {
			testSortIntegers = new HeapSort<>(
					fastShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortIntegers.sortArray();
			if (testSortIntegers.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting", "Fast Sort" })
	public void testRadixSortInt() {

		Reporter.log("[ ** Radix Sort ** ]\n");
		try {
			RadixSort testRadix = new RadixSort(
					fastShuffledArrayInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();

			testRadix.sortArray();
			if (testRadix.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testRadix.sortArray();
			if (testRadix.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testRadix.getArray());

			timeKeeper = System.currentTimeMillis();

			testRadix.sortArray();
			if (testRadix.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Primitive Sort" })
	public void testBubbleSortChar() {

		Reporter.log("[ ** Bubble Sort ** ]\n");
		try {
			testSortCharacters = new BubbleSort<>(
					primitiveShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Primitive Sort" })
	public void testSelectionSortChar() {

		Reporter.log("[ ** Selection Sort ** ]\n");
		try {
			testSortCharacters = new SelectionSort<>(
					primitiveShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Fast Sort" })
	public void testShellSortChar() {

		Reporter.log("[ ** Shell Sort ** ]\n");

		try {
			testSortCharacters = new ShellSort<>(
					fastShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Primitive Sort" })
	public void testInsertionSortChar() {

		Reporter.log("[ ** Insertion Sort ** ]\n");
		try {
			testSortCharacters = new InsertionSort<>(
					primitiveShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (Exception x) {
			System.err.println(x);
			throw x;
		}
	}

	@Test(groups = { "Character-Sorting", "Fast Sort" })
	public void testMergeSortChar() {

		Reporter.log("[ ** Merge Sort ** ]");
		try {
			testSortCharacters = new MergeSort<>(
					fastShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Fast Sort" })
	public void testQuickSortChar() {

		Reporter.log("[ ** Quick Sort ** ]\n");
		try {
			testSortCharacters = new QuickSort<>(
					fastShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting", "Fast Sort" })
	public void testHeapSortChar() {

		Reporter.log("[ ** Heap Sort ** ]\n");
		try {
			testSortCharacters = new HeapSort<>(
					fastShuffledArrayChar.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortCharacters.getArray());

			timeKeeper = System.currentTimeMillis();

			testSortCharacters.sortArray();
			if (testSortCharacters.isSorted())
				Reporter.log("Test Passed : ");
			else
				throw new TestException("Array was not sorted!!!");

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

}
