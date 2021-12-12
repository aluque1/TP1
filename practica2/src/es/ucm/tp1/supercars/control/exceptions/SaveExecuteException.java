package es.ucm.tp1.supercars.control.exceptions;

public class SaveExecuteException extends CommandExecuteException{

	private static final long serialVersionUID = 1L;

	public SaveExecuteException(String format) {
		super(format);
	}

}
