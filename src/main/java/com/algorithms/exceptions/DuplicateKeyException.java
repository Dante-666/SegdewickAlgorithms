package com.algorithms.exceptions;

public class DuplicateKeyException extends Exception{
	
	private static final long serialVersionUID = -3314736440128043308L;
     
    public DuplicateKeyException(){
        super("Duplicate key insertion attempt.");
    }

}
