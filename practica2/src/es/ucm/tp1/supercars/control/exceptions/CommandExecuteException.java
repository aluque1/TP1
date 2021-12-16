package es.ucm.tp1.supercars.control.exceptions;

public class CommandExecuteException extends GameException{
	private static final long serialVersionUID = 1L;
	
	public CommandExecuteException(String format) {
		super(format);
	}

	public CommandExecuteException(String format, Throwable cause) {
		super(format, cause);
	}

}
