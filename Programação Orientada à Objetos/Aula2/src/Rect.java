import java.lang.Math;

public class Rect {
	Ex06_Point2D position;
	Ex06_Point2D size;

	Rect() {
		this(1.0, 1.0);
	}

	Rect(Ex06_Point2D size) {
		this.size = size;
		this.position = new Ex06_Point2D();
	}

	Rect(double width, double height) {
		this.size = new Ex06_Point2D(width, height);
		this.position = new Ex06_Point2D();
	}

	Rect(Ex06_Point2D size, double x, double y) {
		this.size = size;
		this.position = new Ex06_Point2D(x, y);
	}

	Rect(double width, double height, Ex06_Point2D position) {
		this.size = new Ex06_Point2D(width, height);
		this.position = position;
	}

	Rect(Ex06_Point2D size, Ex06_Point2D position) {
		this.size = size;
		this.position = position;
	}

	Rect(double width, double height, double x, double y) {
		this.size = new Ex06_Point2D(width, height);
		this.position = new Ex06_Point2D(x, y);
	}

	boolean hasPoint(double x, double y) {
		return hasPoint(new Ex06_Point2D(x, y));
	}

	boolean hasPoint(Ex06_Point2D point) {
		Ex06_Point2D diff = new Ex06_Point2D(point.x - this.position.x, point.y - this.position.y);
		// Faz a diferença dos vetores "movendo" o ponto para o origem.

		if ((diff.x < 0.0) != (this.size.x < 0.0))
			return false; // Devem estar no mesmo setor em relação à x.

		if ((diff.y < 0.0) != (this.size.y < 0.0))
			return false; // Devem estar no mesmo setor em relação à y

		if (Math.abs(diff.x) > Math.abs(this.size.x))
			return false; // Deve ter uma distância menor ou igual x.

		if (Math.abs(diff.y) > Math.abs(this.size.y)) {
			return false; // Deve ter uma distância menor ou igual x.
		}

		return true;
	}

	boolean isOver(Rect rect) {
		// TODO ->
		/*
		 * Verificar se a distância do canto inferior do retângulo sobre a origem O(0,
		 * 0) é menor que 0.0, ou se o canto superior do retângulo é maior que o tamanho
		 * desse retângulo; e, se o mesmo ocorre para as laterais.
		 */
		Ex06_Point2D diff = new Ex06_Point2D(rect.position.x - this.position.x,
				rect.position.y - this.position.y);
		// Faz a diferença dos vetores "movendo" o retângulo para o origem.
		// ...

		// if ((diff.x < 0.0) != (this.size.x < 0.0))
		// return false; // Devem estar no mesmo setor em relação à x.
		//
		// if ((diff.y < 0.0) != (this.size.y < 0.0))
		// return false; // Devem estar no mesmo setor em relação à y
		//
		// if (Math.abs(diff.x) > Math.abs(this.size.x))
		// return false; // Deve ter uma distância menor ou igual x.
		//
		// if (Math.abs(diff.y) > Math.abs(this.size.y)) {
		// return false; // Deve ter uma distância menor ou igual x.
		// }

		return true;
	}

	@Override
	public String toString() {
		String value = "((w: " + this.size.x + ", h: " + this.size.y + "), (x: " + this.position.x
				+ ", y: " + this.position.y + "))";
		return value;
	}
}
