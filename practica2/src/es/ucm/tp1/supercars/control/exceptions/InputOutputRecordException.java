package es.ucm.tp1.supercars.control.exceptions;

public class InputOutputRecordException extends SaveExecuteException {

	private static final long serialVersionUID = 1L;

	public InputOutputRecordException(String format) {
		super(format);
	}

}
