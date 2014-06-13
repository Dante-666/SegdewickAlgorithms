package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;
import com.algorithms.sorting.InsertionSort;
import com.algorithms.sorting.SelectionSort;
import com.algorithms.sorting.ShellSort;
import com.algorithms.sorting.MergeSort;

import com.algorithms.sorting.Shuffle;
import com.algorithms.sorting.Sort;

import org.testng.annotations.Test;

@Test(groups = "Test-Sorting")
public class TestSorting {

	private final int[] shuffledArray;

	public TestSorting() {
		// TODO Auto-generated constructor stub
		shuffledArray = Shuffle.knuthShuffle(20);
	}

	@Test
	public void testBubbleSort() {

		try {
			Sort testBubble = new BubbleSort(shuffledArray.clone());
			System.out.println("Bubble Sort");
			System.out.println(testBubble.toString());
			testBubble.sortArray();
			System.out.println(testBubble.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

	@Test
	public void testSelectionSort() {

		try {
			Sort testSelection = new SelectionSort(shuffledArray.clone());
			System.out.println("Selection Sort");
			System.out.println(testSelection.toString());
			testSelection.sortArray();
			System.out.println(testSelection.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

	@Test
	public void testShellSort() {

		try {
			Sort testShell = new ShellSort(shuffledArray.clone());
			System.out.println("Shell Sort");
			System.out.println(testShell.toString());
			testShell.sortArray();
			System.out.println(testShell.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

	@Test
	public void testInsertionSort() {

		try {
			System.out.println("Insertion Sort");
			Sort testInsertion = new InsertionSort(shuffledArray.clone());
			System.out.println(testInsertion.toString());
			testInsertion.sortArray();
			System.out.println(testInsertion.toString());
		} catch (Exception x) {
			System.err.println(x);
		}
	}

	@Test
	public void testMergeSort() {

		try {
			Sort testMerge = new MergeSort(shuffledArray.clone());
			System.out.println("Merge Sort");
			System.out.println(testMerge.toString());
			testMerge.sortArray();
			System.out.println(testMerge.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

}
