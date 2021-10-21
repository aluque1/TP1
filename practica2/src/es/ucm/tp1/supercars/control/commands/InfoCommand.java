package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
//TODO ask what this is.
//import es.ucm.tp1.supercars.utils.StringUtils;
import es.ucm.tp1.supercars.view.GamePrinter;

public class InfoCommand extends Command {

	private static final String NAME = "info";

	private static final String DETAILS = "[i]nfo";

	private static final String SHORTCUT = "i";

	private static final String HELP = "prints gameobject info";

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.print("Available objects:");
		// TODO 
		return false;
	}

}