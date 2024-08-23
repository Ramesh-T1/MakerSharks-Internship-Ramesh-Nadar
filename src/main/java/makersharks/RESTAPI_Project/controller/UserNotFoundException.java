package makersharks.RESTAPI_Project.controller;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message)
	{
		super(message);
	}
}
