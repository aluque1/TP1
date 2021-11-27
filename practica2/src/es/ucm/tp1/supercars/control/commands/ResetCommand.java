package es.ucm.tp1.supercars.control.commands;

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
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			params = words;
			if (words.length == 2 || words.length > 3) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				params[0] = words[1];
				params[1] = words[2];
				return this;
			}
		}
		return null;
	}

}
