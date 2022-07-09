package com.cucumber.framework.exception;
	public class AutomationException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AutomationException(String message) {
		super(message);
	}
	
	public AutomationException(){
		this("");
	}

}
