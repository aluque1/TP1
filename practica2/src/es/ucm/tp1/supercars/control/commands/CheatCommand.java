package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command{

	private static final String NAME = "cheat";

	private static final String DETAILS = "Cheat [1...5]";

	private static final String SHORTCUT = "1";

	private static final String HELP = "Removes all elements of last visible column, and adds an Advanced Object";

	private int param;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		game.clearLastVisibleColumn();
		int col = game.getPlayerX() + game.getVisibility() - 1;
		GameObjectGenerator.forceAdvanceObject(game, param, col);
		return true;
	}
	
	protected boolean matchCommandName(String name) {
		return NAME.equalsIgnoreCase(name) || name == String.valueOf(name);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException{
		Command command = null;
		if (matchCommandName(words[0])) {
			if (words.length > 1) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				param = Integer.parseInt(words[0]);
				if(param > 0 && param < 6)
				command = this;
			}
		}
		return command;
	}
}
