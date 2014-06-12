package com.algorithms.sorting;

/**
 * The Merge sort algorithm works by recursively dividing the array till and
 * merges the two arrays based on the order of the elements
 * 
 * @author sinsi02
 * @version 1.0
 */
public class MergeSort extends Sort {
    
    private int[] auxArray;

	/**
	 * The only constructor that initializes the array.
	 * 
	 * @param array
	 *            The array to be sorted
	 */
	public MergeSort(int[] array) {
	    super(array);
	    this.auxArray=new int[this.array.length];
	}

	/**
	 * The sorting method, sorts the private array.
	 */
	public void sortArray() {
	    divideArray(0, this.array.length-1);
	}
    
    /**
     */
    public void divideArray(int left, int right){
	if(right>left){

	    divideArray(left, (left+right)/2);
	    divideArray((left+right)/2+1,right);
	    mergeArray(left,(left+right)/2,right);
	    
	}
    }

	/**
	 * Merge the array.
	 * 
	 * @param left
	 *            The first index
	 * @param middle
	 *            The middle index
	 * @param right
	 *            The second index
	 */
    public void mergeArray(int left, int middle, int right) {
	for(int i = left; i<=right;i++){
	    this.auxArray[i]=this.array[i];
	}
	
	int leftIndex=left;
	int rightIndex=middle+1;
	int primeIndex=left;

	while(leftIndex<=middle && rightIndex<=right){
	    if(this.auxArray[leftIndex]<=this.auxArray[rightIndex]){
		this.array[primeIndex]=this.auxArray[leftIndex];
		leftIndex++;
	    }
	    else{
		this.array[primeIndex]=this.auxArray[rightIndex];
		rightIndex++;
	    }
	    primeIndex++;
	}
	while(leftIndex<=middle){
	    this.array[primeIndex]=this.auxArray[leftIndex];
	    primeIndex++;
	    leftIndex++;
	}
    }
}
