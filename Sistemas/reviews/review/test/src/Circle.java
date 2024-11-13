public class Circle extends Drawing {

	public Circle(Shape shape) {
		super(shape);
	}

	@Override
	public void draw(String what) {
		super.draw("circle " + what);
	}

}
