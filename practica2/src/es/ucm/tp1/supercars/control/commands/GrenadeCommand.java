package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class GrenadeCommand extends Command implements Buyable{

	private static final int GRENADE_PRICE = 3;
	
	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade <x> <y>";

	private static final String SHORTCUT = "g";

	private static final String HELP = "add a grenade in position x, y";
	
	private static final String FAILED_MSG = "grenade could no be placed down";


	private int x, y;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		if (game.isWithinVisibility(x, y)) {
			if (buy(game)) {
				game.placeGrenade(x, y);
				game.update(doesInstantMovement());
				executed = true;
			}
			else 
				System.out.println("Not enough coins to perform this action.");
		}
		else {
			System.out.println("[ERROR]: out of range, " + FAILED_MSG + "\n");
		}
		return executed;
	}

	@Override
	protected Command parse(String[] words) throws CommandParseException{
		Command command = null;
		if (matchCommandName(words[0])) {
			if (words.length != 3) {
				throw new CommandParseException(String.format("[Error] : Command %s: %s", NAME, INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				x = Integer.parseInt(words[1]);
				y = Integer.parseInt(words[2]);
				command = this;
			}
		}
		return command;
	}
	
	@Override
	public int cost() {
		return GRENADE_PRICE;
	}

}
