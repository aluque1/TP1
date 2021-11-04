package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void update() {
		for (GameObject obj : gameObjects) {
			 	obj.update();
			}
	}

	public void add(GameObject go) {
		// TODO Auto-generated method stub
		
	}
}
