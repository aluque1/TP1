package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command{

	private static final String NAME = "move up";

	private static final String DETAILS = "[q] Move up";

	private static final String SHORTCUT = "q";

	private static final String HELP = "moves the car up";
	
	public MoveUpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(game.moveUp()) {
			game.update();
			return true;
		}
			
		else {
			System.out.println("[ERROR] : You are at the edge of the road, you can't move up.");
			return false;
		}
			
	}

}
