package com.example.demo.controllersRest;

public class NotfoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotfoundException(String poruka, String vrednost) {
		super(poruka+" Uneta vrednost: "+vrednost);
	}

}
