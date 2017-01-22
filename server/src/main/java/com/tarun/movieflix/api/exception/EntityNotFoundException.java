package com.tarun.movieflix.api.exception;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4541952283770264791L;

	public EntityNotFoundException(String message){
		super(message);
	}
		
	public EntityNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
