package com.algorithms.exceptions;

public class KeyNotFoundException extends Exception {

	private static final long serialVersionUID = 2419120956384901627L;

	public KeyNotFoundException() {
		super("Key not found.");
	}

}
