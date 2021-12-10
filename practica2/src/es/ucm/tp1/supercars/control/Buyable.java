package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {

	public int cost();
	
	public default boolean buy(Game game) throws NotEnoughCoinsException {
		boolean enoughCoins = false;
		if(game.getPlayerCoins() >= cost()) {
			game.spendCoins(cost());
			enoughCoins = true;
		} else {
			throw new NotEnoughCoinsException("You need " + (cost() - game.getPlayerCoins()) + " coins more");
		}
		return enoughCoins;
	};
	
}
