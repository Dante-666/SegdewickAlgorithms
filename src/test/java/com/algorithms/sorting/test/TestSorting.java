package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleSort;

import org.testng.annotations.Test;

@Test(groups = "Test-Sorting")
public class TestSorting {

        public int[] sortDataGenerator(int seed){

	        int[] array=new int[seed];
		int rand;
		int temp;
		for(int i = 0 ; i < seed - 1 ; i++){
		        array[i]=i;
		}
		for(int i = 0 ; i < seed - 1 ; i++){
		        rand = (int) Math.random() * (seed - 1);
			temp=array[i];
			array[i]=array[rand];
			array[rand]=temp;
		}
		return array;
	}
        @Test
	public void testBubbleSort() {
		
	        int[] array=sortDataGenerator(1000);
		
		try {
		BubbleSort testBubble= new BubbleSort(array);
		System.out.println(testBubble.toString());
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
