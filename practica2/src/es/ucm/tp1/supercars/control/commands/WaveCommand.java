package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantAction.WaveAction;

public class WaveCommand extends Command implements Buyable{

	private static final int WAVE_PRICE = 5;
	
	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "Moves all the visible objects on the road back by one cell for 5 coins.";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		if(buy(game)) {
			game.execute(new WaveAction());
			executed = true;
		}
		if(!executed)
			System.out.println("Not enough coins to perform this action.");
		return executed;
	}

	// Buyable interface implementation ----------------
	@Override
	public int cost() {
		return WAVE_PRICE;
	}
}
