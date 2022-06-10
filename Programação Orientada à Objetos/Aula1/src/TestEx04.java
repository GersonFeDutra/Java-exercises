
public class TestEx04 {
	public static void main(String[] args) {
		Ex04_Car car = new Ex04_Car();
		car.model = "Carro popular";
		car.accelerate();
		car.isOn = true;
		car.accelerate();
		car.desaccelerate();
		car.isOn = false;
	}
}
