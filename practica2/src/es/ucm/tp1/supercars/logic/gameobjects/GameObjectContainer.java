package es.ucm.tp1.supercars.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	Game game;
	
	public GameObjectContainer(Game game) {
		gameObjects = new ArrayList<>();
		this.game = game;
	}
	
	public void update() {
		for (GameObject obj : gameObjects) {
			 	obj.update();
		}
	}

	public void addObject(GameObject go) {
		if (this.isPosEmpty(go.getX(), go.getY())) {
			gameObjects.add(go);
			go.onEnter();
		}
	}
	
	private GameObject auxGetObjectInPosition(int x, int y) {
        GameObject obj = null;
        int i = 0;
        boolean encontrado = false;

        while (i < gameObjects.size() && !encontrado) {
            if (gameObjects.get(i).isInPosition(x, y)) {
                obj = gameObjects.get(i);
                encontrado = true;
            }
            i++;
        }

        return obj;

    }
	
	private boolean isPosEmpty(int x, int y){
        return auxGetObjectInPosition(x, y) == null;
    }

	public String getStringAtPos(int x, int y) {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i).isInPosition(x, y))
				str.append(gameObjects.get(i).toString()).append(" ");
		}
		return str.toString();
	}

	public Collider getObjectInPosition(int x, int y) {
        Collider obj = auxGetObjectInPosition(x, y);
        return obj;
    }
	
	public void removeDead() {
		for(int i = 0; i < gameObjects.size(); i++)
		 	if(!gameObjects.get(i).isAlive()) {
		 		gameObjects.get(i).onDelete();
		 		gameObjects.remove(gameObjects.get(i));
		 		i--;
		 	}
		}

	public void clearContainer() {
		for (GameObject obj : gameObjects) {
		 	obj.onDelete();
		}
		gameObjects.clear();
	}

	public void clearLastVisibleColumn() {
		int col = game.getPlayerX() + game.getVisibility() - 1;
		for(int i = 0; i < gameObjects.size(); i++)
			if(gameObjects.get(i).getX() == col)
				gameObjects.get(i).instaKill();
		removeDead();
	}
	
	public void explode(int x, int y) { // Mover a un new explosion action
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++){
				Collider go = getObjectInPosition(x + i, y + j);
				if(go != null)
					go.receiveShot();
			}
		}
	}
	
}
