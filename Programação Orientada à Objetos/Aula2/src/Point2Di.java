
public class Point2Di {
	int x;
	int y;

	public Point2Di() {
	}

	public Point2Di(int xy) {
		this.x = xy;
		this.y = xy;
	}

	public Point2Di(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point2Di(Point2Di opposite) {
		this.x = -opposite.x;
		this.y = -opposite.y;
	}

	@Override
	public String toString() {
		String value = "(" + this.x + ", " + this.y + ")";
		return value;
	}
}
