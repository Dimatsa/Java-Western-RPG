package rst.character;

import rst.render.Input;
import rst.scene.Bullet;
import rst.scene.Scene;

public class NpcCharacter extends Character {

	private Character target;
	
	private long lastShot;
	
	public NpcCharacter(String firstName, String lastName, int gender, int strength, double speed, int intelligence,
			int drunkeness, double gunSpeed, int gunDamage, CharacterSprite sprite) {
		super(firstName, lastName, gender, strength, speed, intelligence, drunkeness, gunSpeed, gunDamage, sprite);
	}
	
	public void setTarget(Character target) {
		this.target = target;
	}
	
	@Override
	protected void updateLocation(Input input, Scene scene) {
		if(System.nanoTime() >= lastShot + 1000000000 && target != null && target.getHp() > 0) {
			Bullet bullet = new Bullet(location.x, location.y,
					target.getLocation().x,
					target.getLocation().y, this);
			direction = bullet.getBulletDirection();
			scene.addItemRender(bullet);
			lastShot = System.nanoTime();
		}
	}
}
