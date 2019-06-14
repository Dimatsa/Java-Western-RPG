package rst.character;

public class LinearNpcPath extends NpcPath {
	private final double deltaX, deltaY;
	private final double time;
	private final int direction;
	private final double speed;
	
	public LinearNpcPath(double dX, double dY, double time, double speed) {
		this.deltaX = dX;
		this.deltaY = dY;
		this.time = time;
		this.direction = CharacterSprite.pointToDirection(deltaX, deltaY);
		this.speed = speed;
	}

	@Override
	public NpcPathPoint getPoint(double time) {
		if(time < 0 || time > this.time) {
			return null;
		}
		
		NpcPathPoint point = new NpcPathPoint();
		point.direction = direction;
		point.speed = speed;
		point.dX = deltaX * time / this.time;
		point.dY = deltaY * time / this.time;
		
		return point;
	}

	@Override
	public double getTotalTime() {
		return time;
	}
}
