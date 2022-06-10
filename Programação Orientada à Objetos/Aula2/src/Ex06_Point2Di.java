
public class Ex06_Point2Di {
	int x;
	int y;

	public Ex06_Point2Di() {
	}

	public Ex06_Point2Di(int xy) {
		this.x = xy;
		this.y = xy;
	}

	public Ex06_Point2Di(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Ex06_Point2Di(Ex06_Point2Di opposite) {
		this.x = -opposite.x;
		this.y = -opposite.y;
	}

	@Override
	public String toString() {
		String value = "(" + this.x + ", " + this.y + ")";
		return value;
	}
}
