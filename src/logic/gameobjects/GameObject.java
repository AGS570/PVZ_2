
package logic.gameobjects;

import logic.GameWorld;
import logic.Position;

public abstract class GameObject implements GameItem {

    protected GameWorld game;
    protected Position position;
    protected int health;
    protected boolean isAlive;

    protected String name = "";
    protected String nameAndShortcut = "";
    protected String description = "";
    protected String icon = "";

    protected GameObject(GameWorld game, Position position) {
        this.game = game;
        this.position = position;
        this.isAlive = true;
    }

    protected GameObject() {
        this.isAlive = true;
    }

    @Override
    public boolean isInPosition(Position other) {
        return this.position != null
                && this.position.isEqual(other);
    }

    @Override
    public boolean isInRow(Position other) {
        return this.position != null
                && this.position.isInRow(other);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getIcon() {
        return this.icon.formatted(this.health);
    }

    public String getDescription() {
        return this.description;
    }

    public String getNameAndShortcut() {
        return this.nameAndShortcut;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public abstract void update();

    public abstract void onEnter();

    public abstract void onExit();

    public void checkHealth() {
        if (this.health <= 0) {
            this.death();
        }
    }

    protected void death() {
        this.isAlive = false;
    }

    @Override
    public boolean receiveZombieAttack(int damage) {
        return false;
    }

    @Override
    public boolean receivePeaAttack(int damage) {
        return false;
    }
}
