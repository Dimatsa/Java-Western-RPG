/*
 * AABB.java
 * Access align bounding box
 * Dmitry Tsarapkine, Kevin Kurra, Ryan Larkin
 * June 14th, 2019
 * ICS4U
 */
package rst.render;

public class AABB {
	public static class AABBResponse {
		public double toi;
		public double xNormal, yNormal;
	}
	/**
	 * Executes the following code
	 * pre: none
	 * post: the commands have been executed
	 */
	public static AABBResponse sweptAABB(Bounds a, Bounds b, double vX, double vY, double delta) {
		double xInvEntry, yInvEntry;
		double xInvExit, yInvExit;

		// find the distance between the objects on the near and far sides for both x
		// and y
		if (vX > 0) {
			xInvEntry = b.a.x - a.b.x;
			xInvExit = b.b.x - a.a.x;
		} else {
			xInvEntry = b.b.x - a.a.x;
			xInvExit = b.a.x - a.b.x;
		}

		if (vY > 0) {
			yInvEntry = b.a.y - a.b.y;
			yInvExit = b.b.y - a.a.y;
		} else {
			yInvEntry = b.b.y - a.a.y;
			yInvExit = b.a.y - a.b.y;
		}

		// find time of collision and time of leaving for each axis (if statement is to
		// prevent divide by zero)
		double xEntry, yEntry;
		double xExit, yExit;

		if (vX == 0) {
			xEntry = Double.NEGATIVE_INFINITY;
			xExit = Double.POSITIVE_INFINITY;
		} else {
			xEntry = xInvEntry / vX;
			xExit = xInvExit / vX;
		}

		if (vY == 0) {
			yEntry = Double.NEGATIVE_INFINITY;
			yExit = Double.POSITIVE_INFINITY;
		} else {
			yEntry = yInvEntry / vY;
			yExit = yInvExit / vY;
		}

		if (yEntry > delta) {
			yEntry = Double.NEGATIVE_INFINITY;
		}
		if (xEntry > delta) {
			xEntry = Double.NEGATIVE_INFINITY;
		}

		// find the earliest/latest times of collision
		double entryTime = Math.max(xEntry, yEntry);
		double exitTime = Math.min(xExit, yExit);

		AABBResponse resp = new AABBResponse();
		resp.toi = delta;

		if (entryTime > exitTime) {
			return resp; // This check was correct.
		}
		if (xEntry < 0 && yEntry < 0) {
			return resp;
		}
		if (xEntry < 0) {
			// Check that the bounding box started overlapped or not.
			if (a.b.x <= b.a.x || a.a.x >= b.b.x) {
				return resp;
			}
		}
		if (yEntry < 0) {
			// Check that the bounding box started overlapped or not.
			if (a.b.y <= b.a.y || a.a.y >= b.b.y) {
				return resp;
			}
		}

		resp.toi = entryTime;

		// calculate normal of collided surface
		if (xEntry > yEntry) {
			if (xInvEntry < 0) {
				resp.xNormal = 1.0f;
				resp.yNormal = 0.0f;
			} else {
				resp.xNormal = -1.0f;
				resp.yNormal = 0.0f;
			}
		} else {
			if (yInvEntry < 0.0f) {
				resp.xNormal = 0.0f;
				resp.yNormal = 1.0f;
			} else {
				resp.xNormal = 0.0f;
				resp.yNormal = -1.0f;
			}
		}

		// return the time of collision
		return resp;
	}
}
