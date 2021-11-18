	package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

public interface Collider {

	default boolean doCollision() {return false;};

	boolean receiveCollision(Player player);

}
