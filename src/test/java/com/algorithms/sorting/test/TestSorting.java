package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;

import org.testng.annotations.Test;

@Test(groups = "Test-Sorting")
public class TestSorting {

	public void testBubbleSort() {
		//Path file = FileSystems.getDefault().getPath("/src/main/resources", "testGraph.txt"); //"testGraph.txt";
		
	        int[] array={7,8,9,3,4,65,2,541,3,2,25,67,5,55,45,545};
		
		try {
		BubbleSort testBubble= new BubbleSort(array);
		testBubble.sortArray();
		System.out.println(testBubble.toString());
		}
		/*
		catch (IOException x) {
		    System.err.println(x);
		}
		*/
		finally {
		    
		}
	}
}
