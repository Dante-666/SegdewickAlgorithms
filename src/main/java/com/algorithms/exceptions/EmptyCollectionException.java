package com.algorithms.exceptions;

public class EmptyCollectionException extends Exception{

	private static final long serialVersionUID = 7091238070016952720L;

    public EmptyCollectionException(){
        super("Collection is Empty.");
    }
}
