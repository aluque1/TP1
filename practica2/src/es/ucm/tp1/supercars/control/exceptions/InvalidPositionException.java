package es.ucm.tp1.supercars.control.exceptions;

public class InvalidPositionException extends CommandExecuteException{

	private static final long serialVersionUID = 1L;

	public InvalidPositionException() {
		super("Position is not valid");
	}
}
