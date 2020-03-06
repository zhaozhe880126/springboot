package com.zz.scaffold.common.exception;

public class ScaffoldBootException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ScaffoldBootException(String message){
		super(message);
	}
	
	public ScaffoldBootException(Throwable cause)
	{
		super(cause);
	}
	
	public ScaffoldBootException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
