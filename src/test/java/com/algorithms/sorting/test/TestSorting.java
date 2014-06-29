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

@Test(groups = "Sorting")
public class TestSorting {

	private final Integer[] shuffledArrayWithDuplicatesInt;
	private final Character[] shuffledArrayWithDuplicatesChar;
	private Sort<Integer> testSortIntegers;
	private Sort<Character> testSortCharacters;
	private int seed;
	private long timeKeeper;

	public TestSorting() {
		seed = 10000;
		shuffledArrayWithDuplicatesInt = ShuffleArray
				.knuthShuffleWithDuplicatesInt(seed);
		shuffledArrayWithDuplicatesChar = ShuffleArray
				.knuthShuffleWithDuplicatesChar(seed);
		testSortIntegers = null;
		testSortCharacters = null;
		timeKeeper = 0;
	}

	@BeforeMethod
	@Test(groups = { "Integer-Sorting" })
	public void testBubbleSortInt() {

		Reporter.log("[ ** Bubble Sort ** ]\n");

		try {
			testSortIntegers = new BubbleSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array\n");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array\n");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			// Reporter.log(testSortIntegers.toString());
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array\n");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			// Reporter.log(testSortIntegers.toString());
			timeKeeper = System.currentTimeMillis();
			// Thread.sleep(10);
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");
			// Reporter.log(testSortIntegers.toString());
		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting" })
	public void testSelectionSortInt() {

		Reporter.log("[ ** Selection Sort ** ]\n");
		try {
			testSortIntegers = new SelectionSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting" })
	public void testShellSortInt() {

		Reporter.log("[ ** Shell Sort ** ]\n");
		try {
			testSortIntegers = new ShellSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting" })
	public void testInsertionSortInt() {

		Reporter.log("[ ** Insertion Sort ** ]\n");
		try {
			testSortIntegers = new InsertionSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (Exception x) {
			System.err.println(x);
			throw x;
		}
	}

	@Test(groups = { "Integer-Sorting" })
	public void testMergeSortInt() {

		Reporter.log("[ ** Merge Sort ** ]\n");
		try {
			testSortIntegers = new MergeSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting" })
	public void testQuickSortInt() {

		Reporter.log("[ ** Quick Sort ** ]\n");

		try {
			testSortIntegers = new QuickSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Integer-Sorting" })
	public void testHeapSortInt() {

		Reporter.log("[ ** Heap Sort ** ]\n");

		try {
			testSortIntegers = new HeapSort<>(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortIntegers.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortIntegers.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = "Integer-Sorting")
	public void testRadixSortInt() {

		Reporter.log("[ ** Radix Sort ** ]\n");
		try {
			RadixSort testRadix = new RadixSort(
					shuffledArrayWithDuplicatesInt.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testRadix.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testRadix.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testRadix.getArray());
			timeKeeper = System.currentTimeMillis();
			testRadix.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testBubbleSortChar() {

		Reporter.log("[ ** Bubble Sort ** ]\n");
		try {
			testSortCharacters = new BubbleSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testSelectionSortChar() {

		Reporter.log("[ ** Selection Sort ** ]\n");
		try {
			testSortCharacters = new SelectionSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testShellSortChar() {

		Reporter.log("[ ** Shell Sort ** ]\n");

		try {
			testSortCharacters = new ShellSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");
		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testInsertionSortChar() {

		Reporter.log("[ ** Insertion Sort ** ]\n");
		try {
			testSortCharacters = new InsertionSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		} catch (Exception x) {
			System.err.println(x);
			throw x;
		}
	}

	@Test(groups = { "Character-Sorting" })
	public void testMergeSortChar() {

		Reporter.log("[ ** Merge Sort ** ]");
		try {
			testSortCharacters = new MergeSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testQuickSortChar() {

		Reporter.log("[ ** Quick Sort ** ]\n");
		try {
			testSortCharacters = new QuickSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

	@Test(groups = { "Character-Sorting" })
	public void testHeapSortChar() {

		Reporter.log("[ ** Heap Sort ** ]\n");
		try {
			testSortCharacters = new HeapSort<>(
					shuffledArrayWithDuplicatesChar.clone());

			Reporter.log("1. Unsorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("2. Sorted Random Array : ");

			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();
			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

			Reporter.log("3. Reversed Sorted Array : ");

			ShuffleArray.reverseArray(testSortCharacters.getArray());
			timeKeeper = System.currentTimeMillis();
			testSortCharacters.sortArray();

			Reporter.log((System.currentTimeMillis() - timeKeeper) + " ms\n");

		}

		catch (Exception x) {
			System.err.println(x);
			throw x;
		}

	}

}
