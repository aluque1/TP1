package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class ShootCommand extends Command implements InstantAction, Buyable{

	static final int SHOT_PRICE = 1;

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "Clears the road from all obstacles.";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		if(buy(game)) {
			executeShot(game);
			executed = true;
		}
		if(!executed)
			System.out.println("Not enough coins to perform this action.");
		return executed;
	}

	// Buyable interface implementation ----------------
	@Override
	public int cost() {
		return SHOT_PRICE;
	}
}

