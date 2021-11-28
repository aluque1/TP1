package es.ucm.tp1.supercars.logic.instantAction;

import es.ucm.tp1.supercars.logic.Game;

public interface InstantAction {
	
	void execute(Game game);

	default void explosionAction(Game game, int x, int y) {
		game.explode(x, y);
	}
}

