package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SerializeCommand extends Command{
	
	private static final String NAME = "serailize";

	private static final String DETAILS = "[z]: Serialize";

	private static final String SHORTCUT = "z";

	private static final String HELP = "Serializes the game data";

	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		GameSerializer gs = new GameSerializer(game);
		System.out.println(gs.toSerialize());
		return false;
	}

}
