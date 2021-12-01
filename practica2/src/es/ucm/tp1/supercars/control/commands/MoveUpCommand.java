package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command{

	private static final String NAME = "move up";
	
	private static final String DETAILS = "[q]: go up";

	private static final String SHORTCUT = "q";

	private static final String HELP = "moves the car up";
	
	public MoveUpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(!game.checkCollision()) {
		game.moveUp();
		game.update(doesInstantMovement());
		}
		
		return true;
	}
	
	@Override
	protected boolean doesInstantMovement() {
		return true;
	}

}
