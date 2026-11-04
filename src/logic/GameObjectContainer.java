package logic;

import java.util.ArrayList;
import java.util.List;

import logic.gameobjects.GameItem;
import logic.gameobjects.GameObject;



public class GameObjectContainer {

	  private final List<GameObject> gameObjects;	
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
		    	GameObject object = gameObjects.get(i);
		        if (!gameObjects.get(i).isAlive()) {
		        	object.onExit();
		            gameObjects.remove(i);
		            i--;
		        }
		    }
		}
	  
	  public void addObject(GameObject obj) {
		  this.gameObjects.add(obj);
		  obj.onEnter();
	  }
	  public boolean doAttack(GameItem obj) {
		// TODO Auto-generated method stub
		for(GameObject o: this.gameObjects) {
			if(obj.attack(o))return true;
		}
		return false;
	  }
	  public boolean isPositionEmpty(Position position) {
		// TODO Auto-generated method stub
		for(GameObject go : gameObjects) {
			if(go.isInPosition(position))return false;
		}
		return true;
	  }
	  
	  public String positionToString(Position position) {
		// TODO Auto-generated method stub
		  for(GameObject o: this.gameObjects) {
				if(o.isInPosition(position))return o.getIcon();
			}
			return " ";
	  }
	  
	  
	//...
	  
}
