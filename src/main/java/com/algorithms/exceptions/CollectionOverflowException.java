package com.algorithms.exceptions;

public class CollectionOverflowException extends Exception{
	
	private static final long serialVersionUID = -7369645633491306180L;

	public CollectionOverflowException(){
        super("Collection overflowed.");
    }

}
