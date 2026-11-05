package logic.gameobjects.zombies;

import logic.GameWorld;
import logic.Position;
import view.Messages;

public class BucketHeadZombie extends Zombie{

	public BucketHeadZombie(GameWorld game, Position p) {
		super(game, p);
		// TODO Auto-generated constructor stub
		this.health =8;
		this.fr = 4;
		
		this.name = Messages.BUCKET_HEAD_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.BUCKET_HEAD_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
	}

	public BucketHeadZombie() {
		// TODO Auto-generated constructor stub
		super();
		this.health =8;
		this.fr = 4;
		this.name = Messages.BUCKET_HEAD_ZOMBIE_NAME;
		this.description = Messages.ZOMBIE_DESCRIPTION;
		this.icon = Messages.BUCKET_HEAD_ZOMBIE_SYMBOL;
		this.nameAndShortcut = Messages.ZOMBIE_NAME_AND_SHORTCUT;
	}

}
