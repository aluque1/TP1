package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveDownCommand extends Command{
	
	private static final String NAME = "move up";

	private static final String DETAILS = "Move up[q]";

	private static final String SHORTCUT = "q";

	private static final String HELP = "moves the car up";

	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(game.moveDown())
			return true;
		else{
			System.out.println("[ERROR] : You are at the edge of the road, you can't move down.");
			return false;
		}
	}

}
