
public class Point2D {
	double x;
	double y;

	public Point2D() {
	}

	public Point2D(double xy) {
		this.x = xy;
		this.y = xy;
	}

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point2D(Point2D opposite) {
		this.x = -opposite.x;
		this.y = -opposite.y;
	}

	@Override
	public String toString() {
		String value = "(" + this.x + ", " + this.y + ")";
		return value;
	}
	
	public void add(double xy) {
		this.x += xy;
		this.y += xy;
	}
	
	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void add(Point2D point) {
		this.x += point.x;
		this.y += point.y;
	}
}
