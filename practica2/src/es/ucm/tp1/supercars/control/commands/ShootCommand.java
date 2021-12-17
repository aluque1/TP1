package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantAction.ShotAction;

public class ShootCommand extends Command implements Buyable{

	static final int SHOT_PRICE = 1;

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";

	private static final String FAILED_MSG = "could not shoot, not enough coins";
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		boolean executed = false;
		try {
			buy(game);
			game.execute(new ShotAction());
			executed = true;
			game.update(doesInstantMovement());
		} catch (NotEnoughCoinsException e) {
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
		return executed;
	}

	// Buyable interface implementation ----------------
	@Override
	public int cost() {
		return SHOT_PRICE;
	}
}

