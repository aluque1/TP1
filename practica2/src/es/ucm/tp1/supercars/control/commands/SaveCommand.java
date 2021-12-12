package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class SaveCommand extends Command{
	private static final String NAME = "save";

	private static final String DETAILS = "[v]: Save <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Saves the game data in the file specified by the user";

	private String filename;
	
	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		// TODO do the appropriate calls
		return false;
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException{
		Command command = null;
		if (super.matchCommandName(words[0])) {
			if (words.length != 2) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			}
			
			filename = words[1];
			command = this;
		}
		return command;
	}
	
}
