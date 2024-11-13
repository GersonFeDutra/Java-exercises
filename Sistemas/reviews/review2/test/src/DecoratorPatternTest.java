public class DecoratorPatternTest {
	public static void main(String[] args) throws Exception {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");

		Car sportsLuxuryCar = new SportsCar(new BasicCar());
		sportsLuxuryCar.assemble();
	}
}
