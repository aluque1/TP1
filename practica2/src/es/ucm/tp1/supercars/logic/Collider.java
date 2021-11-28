package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;

public interface Collider {

	default boolean doCollision() {return false;};
	
	default boolean receiveShot() {return false;};

	default boolean receiveCollision(Player player) {return false;};

	default boolean receiveCollision(Truck truck) {return false;};
	
	boolean receiveWave();
}
