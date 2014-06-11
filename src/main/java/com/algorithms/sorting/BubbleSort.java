package com.algorithms.sorting;

public class BubbleSort {
    private final int[] array;
    private long arrayAccess;
    private long comparisions;

    /**
     *
     */
    public BubbleSort(int[] array){
	this.array=array;
	this.arrayAccess=0;
	this.comparisions=0;
    }

    public void sortArray(){

	for(int i = this.array.length-1 ; i > 0 ; i--){

	    for(int j = 0 ; j < i ; j++){
		this.arrayAccess+=2;
		this.comparisions++;
		if(this.array[j+1]<this.array[j]){
		    swapArrayValues(j+1,j);
		}
	    }

	}
    }

    public void swapArrayValues(int x, int y){
	int temp = this.array[x];
	
	this.array[x]=this.array[y];
	this.array[y]=temp;

	this.arrayAccess+=4;
    }
    
    public long getArrayAccessCount(){
	return this.arrayAccess;
    }

    public long getComparisions(){
	return this.comparisions;
    }

    public String toString(){
	String temp="";
	
	for (int i = 0 ; i < this.array.length - 1 ; i++) {
	    temp+= this.array[i] + " ";
	}

	temp+="\nArray Length: " 
	    + this.array.length 
	    + "\nArray Comparisions: "
	    + this.getComparisions()
	    + "\nArray Access: "
	    + this.getArrayAccessCount();
	
	return temp;
    }
}
