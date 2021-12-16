package es.ucm.tp1.supercars.control.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException{
	private static final long serialVersionUID = 1L;
	
	public NotEnoughCoinsException() {
		super("Not enough coins");
	}

}
