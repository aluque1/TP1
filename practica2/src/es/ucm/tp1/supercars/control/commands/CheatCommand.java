package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class CheatCommand extends Command{

	private static final String NAME = "cheat";

	private static final String DETAILS = "Cheat [1...5]";

	private static final String SHORTCUT = "1";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

	private String param;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		game.clearLastVisibleColumn();
		// añadimos el objeto
		return true;
	}
	
	@Override
	protected Command parse(String[] words) {
		Command command = null;
		if (matchCommandName(words[0])) {
			if (words.length > 2 && words.length < 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
			} else {
				param = words[0];
				command = this;
			}
		}
		return command;
	}
}
