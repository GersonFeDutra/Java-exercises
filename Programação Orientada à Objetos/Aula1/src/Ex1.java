
public class Ex1 {
	public static void main(String[] args) {
		Car car = new Car();
		car.model = "Carro popular";
		car.accelerate();
		car.isOn = true;
		car.accelerate();
		car.desaccelerate();
		car.isOn = false;
	}
}
