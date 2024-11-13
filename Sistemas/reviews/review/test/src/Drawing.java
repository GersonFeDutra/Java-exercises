public class Drawing implements Shape {
	public Shape shape;

	public Drawing(Shape shape) {
		System.out.println("construct");
		this.shape = shape;
	}

	@Override
	public void draw(String what) {
		System.out.println("draw");
	}

	public void add(Shape shape) {
		System.out.println("add");
	}

	public void remove(Shape shape) {
		System.out.println("remove");
	}

	public void clear() {
		System.out.println("clear");
	}
}
