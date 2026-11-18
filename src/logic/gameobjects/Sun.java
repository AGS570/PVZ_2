package logic.gameobjects;

import logic.gameobjects.plants.PeaShooter;
import logic.gameobjects.zombies.Zombie;

public class Sun extends GameObject{
	


@Override
public boolean isInExplosionRange(GameItem other) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean receiveAttack(GameObject obj, int damage) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean receiveAttack(Zombie obj, int dmg) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean receiveAttack(PeaShooter obj, int damage) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void update() {
	// TODO Auto-generated method stub
	
}

@Override
public void onEnter() {
	// TODO Auto-generated method stub
	
}

@Override
public void onExit() {
	// TODO Auto-generated method stub
	
}

}
