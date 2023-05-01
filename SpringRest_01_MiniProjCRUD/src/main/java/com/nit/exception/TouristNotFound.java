package com.nit.exception;

public class TouristNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;
	public TouristNotFound(String msg) {
		super(msg);
	}
}
