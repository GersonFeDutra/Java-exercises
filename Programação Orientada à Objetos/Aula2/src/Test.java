import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// testPoint2D();
		// testRectOffsets(0.0);
		// System.out.printf("\n-----------------------------------------\n");
		testRectOffsets(-10.0);
		System.out.printf("\n-----------------------------------------\n");
		testRectOffsets(new Point2D(10.0, -10.0));
	}
	
	private static void testRectOffsets(double at) {
		testRectOffsets(new Point2D(at));
	}
	
	private static void testRectOffsets(Point2D at) {
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
		testRect(new Point2D(0.5, -0.5), at);
		System.out.println();
		testRect(new Point2D(-0.5, 0.5), at);
	}

	private static void testRect(float offset, Point2D at) {
		testRect(new Point2D(offset), at);
	}
	
	private static void testRect(Point2D offset, Point2D at) {
		offset.add(at);
		
		Rect rect1 = new Rect(new Point2D(1.0), offset);
		Point2D point = new Point2D();

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

	private static void showPointInRect(Rect rect, Point2D point) {
		System.out.printf("O ponto %s %s no retângulo.\n", point.toString(),
				rect.hasPoint(point) ? "está" : "não está");
	}

	private static void testPoint2D() {
		Scanner scan = new Scanner(System.in);
		Point2D p1 = new Point2D();
		System.out.printf("P1: %s\n", p1.toString());

		System.out.println("Insira as coordenadas (x, y) para o ponto P2: ");
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		Point2D p2 = new Point2D(x, y);

		System.out.printf("P2: %s\n", p2.toString());
		System.out.println("Digite um valor para ambas as coordenadas do ponto P3: ");
		x = scan.nextDouble();

		Point2D p3 = new Point2D(x);
		System.out.printf("P3: %s\n", p3.toString());

		Point2D p4 = new Point2D(p2);
		System.out.printf("P4: %s\n", p4.toString());
		scan.close();
	}

}
