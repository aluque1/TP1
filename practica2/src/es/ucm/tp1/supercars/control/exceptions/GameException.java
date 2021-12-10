package es.ucm.tp1.supercars.control.exceptions;

public class GameException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public GameException() {
		super();
	}
	
	public GameException(String message) {
		super(message);
	}
	
	// TODO Delete if we do not use this.
	public GameException(String message, Throwable cause) {
		super(message, cause);
	}
}