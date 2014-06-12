package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;
//import com.algorithms.sorting.InsertionSort;
import com.algorithms.sorting.Shuffle;
import com.algorithms.sorting.Sort;

import org.testng.annotations.Test;

@Test(groups = "Test-Sorting")
public class TestSorting {

	private final int[] shuffledArray;

	public TestSorting() {
		// TODO Auto-generated constructor stub
		shuffledArray = Shuffle.getReverseSortedArray(100);
	}

	@Test
	public void testBubbleSort() {

		//int[] array = shuffledArray;

		try {
			Sort testBubble = new BubbleSort(shuffledArray.clone());
			System.out.println(testBubble.toString());
			testBubble.sortArray();
			System.out.println(testBubble.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}
	
	/*@Test
	public void testMergeSort() {

		//int[] array = shuffledArray;

		try {
			MergeSort testBubble = new MergeSort(shuffledArray.clone());
			System.out.println(testBubble.toString());
			testBubble.sortArray();
			System.out.println(testBubble.toString());
		}

		catch (Exception x) {
			System.err.println(x);
		}

	}
*/
/*	public void testInsertionSort() {

		// int[] array = shuffledArray;

		try {
			InsertionSort testInsertion = new InsertionSort(shuffledArray.clone());
			System.out.println(testInsertion.toString());
			testInsertion.sortArray();
			System.out.println(testInsertion.toString());
		} catch (Exception x) {
			System.err.println(x);
		}
	}*/
}
