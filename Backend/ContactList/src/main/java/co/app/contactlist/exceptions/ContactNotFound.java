package co.app.contactlist.exceptions;

public class ContactNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactNotFound(String message) {
		super(message);
	}
}
