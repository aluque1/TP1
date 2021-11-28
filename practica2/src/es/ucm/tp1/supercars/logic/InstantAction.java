package es.ucm.tp1.supercars.logic;

public interface InstantAction {



	default void executeShot(Game game) {
		// TODO IMPLEMENT SHOT 
	}

	default void executeWave(Game game) {
		game.recieveWave();
	}
	
	default void explosionAction(Game game, int x, int y) {
		game.explode(x, y);
	}
}

