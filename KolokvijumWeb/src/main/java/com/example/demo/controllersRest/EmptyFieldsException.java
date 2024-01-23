package com.example.demo.controllersRest;

public class EmptyFieldsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyFieldsException(String poruka) {
		super(poruka);
	}

}
