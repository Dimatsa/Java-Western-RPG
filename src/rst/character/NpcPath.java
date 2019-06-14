package rst.character;

public abstract class NpcPath {
	public abstract NpcPathPoint getPoint(double time);
	public abstract double getTotalTime();
}
