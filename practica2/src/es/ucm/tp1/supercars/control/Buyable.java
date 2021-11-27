package es.ucm.tp1.supercars.control;

import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {

	public int cost();
	
	public default boolean buy(Game game){
		boolean enoughCoins = false;
		
		if(game.getPlayerCoins() >= cost()) {
			game.spendCoins(cost());
			enoughCoins = true;
		}
		return enoughCoins;
	};
	
}
