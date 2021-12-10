package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class GameSerializer {

	private Game game;
	
	public GameSerializer(Game game) {
		this.game = game;
	}
	
	private static String formatTime(long t) {
		return String.format("%.2f s", t / 1000.0);
	}
	
	protected String getInfo() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		buffer.
		append("Level: ").append(game.getLevel()).append(StringUtils.LINE_SEPARATOR)
		.append("Cycles: ").append(game.getCycle()).append(StringUtils.LINE_SEPARATOR)
		.append("Coins: ").append(game.playerCoins()).append(StringUtils.LINE_SEPARATOR)
		.append("EllapsedTime: ").append(formatTime(game.elapsedTime())).append(StringUtils.LINE_SEPARATOR)
		.append("Game Objects:").append(StringUtils.LINE_SEPARATOR);
		return buffer.toString();
	}
	
	
	public String toSerialize() {
		StringBuilder str = new StringBuilder();
		
		str.append("---- ROAD FIGHTER SERIALIZED ----").append(StringUtils.LINE_SEPARATOR);

		// Game Status

		str.append(getInfo());

		// add serialized data game
		str.append(game.toSerialize());
		return str.toString();
	}
}
