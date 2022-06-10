
public class Ex04_Car {
	boolean isOn;
	int doors = 4;
	String model;

	public void accelerate() {

		if (isOn) {
			System.out.println("Carro acelerado!");
		} else {
			System.out.println("Não é possível acelerar o carro.");
		}
	}

	public void desaccelerate() {

		if (isOn) {
			System.out.println("Freando o carro!");
		} else {
			System.out.println("Não é possível desacelerar o carro.");
		}
	}
}
