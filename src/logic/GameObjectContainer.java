package logic;

import java.util.ArrayList;
import java.util.List;

import logic.gameobjects.GameItem;
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
		clean();
	  }
	  
	  /*private void clean() {
		// TODO Auto-generated method stub
		  for(GameObject go: gameObjects) {
			  
				if(!go.isAlive()) {
					this.gameObjects.remove(go);
				}
			}
	  }*/
	  
	  
	  private void clean() {
		    for (int i = 0; i < gameObjects.size(); i++) {
		        if (!gameObjects.get(i).isAlive()) {
		            gameObjects.remove(i);
		            i--;
		        }
		    }
		}
	  
	  public void addObject(GameObject obj) {
		  this.gameObjects.add(obj);
	  }
	  public boolean doAttack(GameItem obj) {
		// TODO Auto-generated method stub
		for(GameObject o: this.gameObjects) {
			if(obj.attack(o))return true;
		}
		return false;
	  }
	  
	  
	//...
	  
}
