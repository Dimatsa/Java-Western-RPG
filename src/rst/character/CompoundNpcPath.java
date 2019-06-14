package rst.character;

public class CompoundNpcPath extends NpcPath {

	private final NpcPath[] paths;
	private final double total;
	
	public CompoundNpcPath(NpcPath...paths) {
		this.paths = paths;
		double sum = 0;
		for(NpcPath path : paths) {
			sum += path.getTotalTime();
		}
		total = sum;
	}

	@Override
	public NpcPathPoint getPoint(double time) {
		int sum = 0;
		double sumX = 0; double sumY = 0;
		for(int i = 0; i < paths.length; i++) {
			sum += paths[i].getTotalTime();
			
			NpcPathPoint p = paths[i].getPoint(paths[i].getTotalTime());
			
			sumX += p.dX;
			sumY += p.dY;
			
			if(time <= sum) {
				NpcPathPoint finalP = paths[i].getPoint(time - sum + paths[i].getTotalTime());
				finalP.dX += sumX - p.dX;
				finalP.dY += sumY - p.dY;
				return finalP;
			}
		}
		
		return null;
	}

	@Override
	public double getTotalTime() {
		return total;
	}
}
