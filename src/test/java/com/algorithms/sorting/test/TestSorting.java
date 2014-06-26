package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;
import com.algorithms.sorting.HeapSort;
import com.algorithms.sorting.InsertionSort;
import com.algorithms.sorting.RadixSort;
import com.algorithms.sorting.SelectionSort;
import com.algorithms.sorting.ShellSort;
import com.algorithms.sorting.MergeSort;
import com.algorithms.sorting.QuickSort;
import com.algorithms.sorting.Shuffle;
import com.algorithms.sorting.Sort;

import org.testng.annotations.Test;

@Test(groups = "Test-Sorting")
public class TestSorting {

	private final Integer[] shuffledArray;

	public TestSorting() {
		// TODO Auto-generated constructor stub
		shuffledArray = Shuffle.knuthShuffleWithDuplicates(20);
	}

	@Test
	public void testBubbleSort() {

		try {
			Sort<Integer> testBubble = new BubbleSort<>(shuffledArray.clone());
			System.out.println("<----Bubble Sort---->");
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
			Sort<Integer> testSelection = new SelectionSort<>(
					shuffledArray.clone());
			System.out.println("<----Selection Sort---->");
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
			Sort<Integer> testShell = new ShellSort<>(shuffledArray.clone());
			System.out.println("<----Shell Sort---->");
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
			System.out.println("<----Insertion Sort---->");
			Sort<Integer> testInsertion = new InsertionSort<>(
					shuffledArray.clone());
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
			Sort<Integer> testMerge = new MergeSort<>(shuffledArray.clone());
			System.out.println("<----Merge Sort---->");
			System.out.println(testMerge.toString());
			testMerge.sortArray();
			System.out.println(testMerge.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

	//@Test
	/*public void testQuickSort() {

		try {
			Sort<Integer> testQuick = new QuickSort<>(shuffledArray.clone());
			System.out.println("<----Quick Sort---->");
			System.out.println(testQuick.toString());
			testQuick.sortArray();
			System.out.println(testQuick.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}*/

	@Test
	public void testHeapSort() {

		try {
			Sort<Integer> testHeap = new HeapSort<>(shuffledArray.clone());
			System.out.println("<----Heap Sort---->");
			System.out.println(testHeap.toString());
			testHeap.sortArray();
			System.out.println(testHeap.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}
	
	@Test
	public void testRadixSort() {

		try {
			RadixSort testRadix = new RadixSort(shuffledArray.clone());
			System.out.println("<----Radix Sort---->");
			System.out.println(testRadix.toString());
			testRadix.sortArray();
			System.out.println(testRadix.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}

}
