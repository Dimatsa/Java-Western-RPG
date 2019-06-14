package rst.character;

import rst.datastructures.Queue;
import rst.render.Coordinates;
import rst.render.Input;
import rst.scene.Bullet;
import rst.scene.Scene;

public class NpcCharacter extends Character {

	private final Queue<Character> targets;
	
	private long movementStart;
	private NpcPath path;
	private double startX, startY;
	
	private long lastShot;
	
	public NpcCharacter(String firstName, String lastName, int gender, int strength, double speed, int intelligence,
			int drunkeness, double gunSpeed, int gunDamage, CharacterSprite sprite) {
		super(firstName, lastName, gender, strength, speed, intelligence, drunkeness, gunSpeed, gunDamage, sprite);
		
		targets = new Queue<>();
	}
	
	public void setTarget(Character target) {
		targets.enqueue(target);
	}
	
	public void emptyTargets() {
		targets.makeEmpty();
	}
	
	@Override
	protected void updateLocation(Input input, Scene scene) {
		if(path != null) {
			if(movementStart == -1) {
				movementStart = System.nanoTime();
				startX = location.x;
				startY = location.y;
			}
			
			double deltaT = (System.nanoTime() - movementStart) / 1000000000.0;
			NpcPathPoint point = path.getPoint(deltaT);
			if(point == null) {
				path = null;
				
				this.currentSpeed = 0;
			}
			else {
				this.location.x = startX + point.dX;
				this.location.y = startY + point.dY;
				bounds.a.x = location.x - 20;
				bounds.a.y = location.y - 40;
				bounds.b = new Coordinates();
				bounds.b.x = location.x + 20;
				bounds.b.y = location.y + 40;
				
				this.direction = point.direction;
				this.currentSpeed = point.speed;
			}
		}
		
		if(!targets.isEmpty() && targets.front().getHp() <= 0) {
			targets.dequeue();
		}
		
		if(System.nanoTime() >= lastShot + 1000000000 && !targets.isEmpty()) {
			Bullet bullet = new Bullet(location.x, location.y,
					targets.front().getLocation().x,
					targets.front().getLocation().y, this);
			direction = bullet.getBulletDirection();
			scene.addItemRender(bullet);
			lastShot = System.nanoTime();
		}
	}
	
	public void setMovement(NpcPath path) {
		this.path = path;
		movementStart = -1;
	}
}
