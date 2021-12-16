package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command{

	private static final String NAME = "record";

	private static final String DETAILS = "[o]: record";

	private static final String SHORTCUT = "o";

	private static final String HELP = "Show level record";

	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println(game.getLevel().name() + " record is " + formatRecord(game.getRecord()));
		return false;
	}
	
	private static String formatRecord(long t) {
		return String.format("%.2f s", t / 1000.0);
	}
}
