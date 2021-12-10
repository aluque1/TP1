package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
import es.ucm.tp1.supercars.logic.Collider;

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
		int col = game.getPlayerX() + game.getVisibility() - 1;
		clearLastVisibleColumn(game, col);
		GameObjectGenerator.forceAdvanceObject(game, param, col);
		return true;
	}

	private void clearLastVisibleColumn(Game game, int col) {
		for(int i = 0; i < game.getRoadWidth(); i++) {
			Collider go = game.getObjectInPosition(col, i);
			if(go != null)
				go.instaKill();
			game.removeDeadObjects();
		}
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException{
		Command command = null;
		try{
			Integer.valueOf(words[0]);
			if (words.length > 1) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				param = Integer.parseInt(words[0]);
				if(param > 0 && param < 6)
					command = this;
			}
		} catch (NumberFormatException e) {
			//not an integer
		}
		return command;
	}
}
