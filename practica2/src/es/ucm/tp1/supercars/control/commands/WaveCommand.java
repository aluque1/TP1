package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantAction.WaveAction;

public class WaveCommand extends Command implements Buyable{

	private static final int WAVE_PRICE = 5;
	
	private static final String NAME = "wave";

	private static final String DETAILS = "[w]ave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "Moves all the visible objects on the road back by one cell for 5 coins.";

	private static final String FAILED_MSG = "Wave could not be bought. Not enough coins";
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		boolean executed = false;
		try {
			buy(game);
			// No se porque no funciona
			game.execute(new WaveAction()); 
			executed = true;
		} catch (NotEnoughCoinsException e) {
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG), e);
		}
		return executed;
	}

	// Buyable interface implementation ----------------
	@Override
	public int cost() {
		return WAVE_PRICE;
	}
}
