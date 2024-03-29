package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command{
	
	private static final String NAME = "reset";
	
	private static final String DETAILS = "[r]eset [<level> <seed>]";

	private static final String SHORTCUT = "r";

	private static final String HELP = "resets the game";
	
	private String[] params;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.reset(params);
		return true;
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException, NumberFormatException{
		Command command = null;
		if (super.matchCommandName(words[0])) {
			params = words;
			if (words.length != 1 && words.length != 3) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			}
			else if(words.length == 3){
				params[0] = words[1];
				params[1] = words[2];
			}
			command = this;
		}
		return command;
	}

}
