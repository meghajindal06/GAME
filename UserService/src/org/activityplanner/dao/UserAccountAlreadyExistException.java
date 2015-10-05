package org.activityplanner.dao; 


public class UserAccountAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAccountAlreadyExistException() {
		super();
	}

	public UserAccountAlreadyExistException(String msg) {
		super(msg);
	}
}
