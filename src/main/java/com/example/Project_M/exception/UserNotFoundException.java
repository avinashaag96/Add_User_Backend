package com.example.Project_M.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Integer id)
	{
		super("could not found the user with id "+id);
	}

}
