
public class Ex03_Pen {
	String color;
	double charge = 100.0;
	boolean isCapped = true;

	void write() {

		if (charge == 0.0) {
			System.out.println("Caneta sem carga!");
		}
		else if (!isCapped) {
			System.out.println("Escrevendo...");
			charge -= 1.0;
		}
		else
			System.out.println("Caneta tampada! Não é possível escrever.");
	}

	void draw() {

		if (charge == 0.0) {
			System.out.println("Caneta sem carga!");
		}
		else if (!isCapped) {
			System.out.println("Desenhando...");
			charge -= 1.0;
		}
		else
			System.out.println("Caneta tampada! Não é possível desenhar.");
	}

	void cap() {
		isCapped = true;
	}

	void uncap() {
		isCapped = false;
	}

	public String toString() {
		return "Cor = " + this.color + "; Carga = " + this.charge + "; Tampada = " + this.isCapped;
	}
}
