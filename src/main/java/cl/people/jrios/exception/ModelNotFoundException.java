package cl.people.jrios.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4993089377546996455L;

	public ModelNotFoundException(String message) {
		super(message);
	}
}
