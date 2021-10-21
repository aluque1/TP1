package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {

		// TODO refactor this code to the random generator we have in P1
		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
		}
	}

	public static void reset(Level level) {
		// TODO add your code
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
}
