import java.util.Scanner;

public class TestEx06 {

	public static void main(String[] args) {
		// testPoint2D();
		// testRectOffsets(0.0);
		// System.out.printf("\n-----------------------------------------\n");
		testRectOffsets(-10.0);
		System.out.printf("\n-----------------------------------------\n");
		testRectOffsets(new Ex06_Point2D(10.0, -10.0));
	}

	private static void testRectOffsets(double at) {
		testRectOffsets(new Ex06_Point2D(at));
	}

	private static void testRectOffsets(Ex06_Point2D at) {
		testRect(0.0f, at);
		System.out.println();
		testRect(0.5f, at);
		System.out.println();
		testRect(1.0f, at);
		System.out.println();
		testRect(-0.5f, at);
		System.out.println();
		testRect(-1.0f, at);
		System.out.println();
		testRect(new Ex06_Point2D(0.5, -0.5), at);
		System.out.println();
		testRect(new Ex06_Point2D(-0.5, 0.5), at);
	}

	private static void testRect(float offset, Ex06_Point2D at) {
		testRect(new Ex06_Point2D(offset), at);
	}

	private static void testRect(Ex06_Point2D offset, Ex06_Point2D at) {
		offset.add(at);

		Ex06_Rect rect1 = new Ex06_Rect(new Ex06_Point2D(1.0), offset);
		Ex06_Point2D point = new Ex06_Point2D();

		System.out.printf("Dado o retângulo %s:\n", rect1.toString());

		point.add(at);
		showPointInRect(rect1, point);

		point.x = at.x + 2.0;
		showPointInRect(rect1, point);

		point.y = at.y + 2.0;
		showPointInRect(rect1, point);

		point.x = at.x + 1.0;
		showPointInRect(rect1, point);

		point.y = at.y + 1.0;
		showPointInRect(rect1, point);

		point.x = at.x + -1.0;
		showPointInRect(rect1, point);

		point.y = at.y + -1.0;
		showPointInRect(rect1, point);

		point.x = at.x + 1.0;
		showPointInRect(rect1, point);

		point.x = at.x + 0.5;
		point.y = at.y + 0.5;
		showPointInRect(rect1, point);
	}

	private static void showPointInRect(Ex06_Rect rect, Ex06_Point2D point) {
		System.out.printf("O ponto %s %s no retângulo.\n", point.toString(),
				rect.hasPoint(point) ? "está" : "não está");
	}

	private static void testPoint2D() {
		Scanner scan = new Scanner(System.in);
		Ex06_Point2D p1 = new Ex06_Point2D();
		System.out.printf("P1: %s\n", p1.toString());

		System.out.println("Insira as coordenadas (x, y) para o ponto P2: ");
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		Ex06_Point2D p2 = new Ex06_Point2D(x, y);

		System.out.printf("P2: %s\n", p2.toString());
		System.out.println("Digite um valor para ambas as coordenadas do ponto P3: ");
		x = scan.nextDouble();

		Ex06_Point2D p3 = new Ex06_Point2D(x);
		System.out.printf("P3: %s\n", p3.toString());

		Ex06_Point2D p4 = new Ex06_Point2D(p2);
		System.out.printf("P4: %s\n", p4.toString());
		scan.close();
	}

}
