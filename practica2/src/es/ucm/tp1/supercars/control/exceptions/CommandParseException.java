package es.ucm.tp1.supercars.control.exceptions;

public class CommandParseException extends GameException{
	
	private static final long serialVersionUID = 1L;
	
	public CommandParseException(String format) {
		super(format);
	}
	
	public CommandParseException(String format, Throwable cause) {
		super(format, cause);
	}
}
