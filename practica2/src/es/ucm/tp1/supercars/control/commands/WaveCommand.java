package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class WaveCommand extends Command {

	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = " Moves all the visible objects on the road back by one cell for 5 coins.";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		boolean refresh = false;
		if(game.doWaveAttack())
			refresh = true;
		return refresh;
	}

}
