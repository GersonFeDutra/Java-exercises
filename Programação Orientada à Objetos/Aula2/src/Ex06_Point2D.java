
public class Ex06_Point2D {
	double x;
	double y;

	public Ex06_Point2D() {
	}

	public Ex06_Point2D(double xy) {
		this.x = xy;
		this.y = xy;
	}

	public Ex06_Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Ex06_Point2D(Ex06_Point2D opposite) {
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

	public void add(Ex06_Point2D point) {
		this.x += point.x;
		this.y += point.y;
	}
}
