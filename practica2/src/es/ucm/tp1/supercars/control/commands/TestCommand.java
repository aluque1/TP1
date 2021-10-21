package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class TestCommand extends Command{

	private static final String NAME = "test";

	private static final String DETAILS = "[t]est";

	private static final String SHORTCUT = "t";

	private static final String HELP = "toggles test mode";
	
	public TestCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
