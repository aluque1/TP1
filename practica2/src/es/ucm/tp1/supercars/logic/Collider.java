package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

public interface Collider {
	
	default boolean receiveShot() {return false;};

	default boolean receiveCollision(Player player) {return false;};
	
	default boolean receiveWave() {return false;};
	
	default boolean recieveThunder() {return false;};
	
	default void instaKill() {};
	
}
