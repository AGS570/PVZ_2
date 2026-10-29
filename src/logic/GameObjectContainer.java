package logic;

import java.util.ArrayList;
import java.util.List;

import logic.gameobjects.GameObject;
import logic.gameobjects.ZombieManager;

public class GameObjectContainer {

	  private List<GameObject> gameObjects;
	  private ZombieManager zMng;
	  public GameObjectContainer() {
	    gameObjects = new ArrayList<>();
	  }
	  public void update() {
		// TODO Auto-generated method stub
		for(GameObject go: gameObjects) {
			go.update();
		}
	  }
	  
	  
	//...
	  
}
