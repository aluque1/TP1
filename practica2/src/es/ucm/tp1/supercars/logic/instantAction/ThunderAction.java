package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Game;

public class ThunderAction implements InstantAction{

	@Override
	public void execute(Game game) {
		game.recieveThunder();
	}

}
