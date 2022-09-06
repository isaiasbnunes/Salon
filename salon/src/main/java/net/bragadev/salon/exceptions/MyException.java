package net.bragadev.salon.exceptions;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public MyException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
