package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveDownCommand extends Command{
	
	private static final String NAME = "move down";

	private static final String DETAILS = "[a] Move up";

	private static final String SHORTCUT = "a";

	private static final String HELP = "moves the car down";

	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(game.moveDown()){
			game.update();
			return true;
		}
		else{
			System.out.println("[ERROR] : You are at the edge of the road, you can't move down.");
			return false;
		}
	}

}
