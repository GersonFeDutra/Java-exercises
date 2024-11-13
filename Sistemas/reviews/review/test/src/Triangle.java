public class Triangle extends Drawing {

	public Triangle(Shape shape) {
		super(shape);
	}

	@Override
	public void draw(String what) {
		super.draw("Triangle " + what);
	}

}
