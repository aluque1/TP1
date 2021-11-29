package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

public interface Collider {

	default boolean doCollision() {return false;};
	
	default boolean receiveShot() {return false;};

	default boolean receiveCollision(Player player) {return false;};
	
	boolean receiveWave();
	
	default boolean recieveThunder() {return false;};
	
}
