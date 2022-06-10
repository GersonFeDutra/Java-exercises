
public class TestEx03 {

	public static void main(String[] args) {
		Ex03_Pen pen1 = new Ex03_Pen();
		Ex03_Pen pen2 = new Ex03_Pen();
		pen1.color = "Azul";
		pen2.color = "Vermelha";
		System.out.println("1: " + pen1.toString());
		System.out.println("2: " + pen2.toString());
		pen2.charge = 50.0;
		System.out.println("2: " + pen2.toString());
		pen2.uncap();
		System.out.println("2: " + pen2.toString());
		pen2.draw();
		System.out.println("2: " + pen2.toString());
		pen1.draw();
		System.out.println("1: " + pen1.toString());
		pen1.uncap();
		System.out.println("1: " + pen1.toString());
		pen1.draw();
		System.out.println("1: " + pen1.toString());
		pen1.charge = 90.0;
		System.out.println("1: " + pen1.toString());
		pen1.write();
		System.out.println("1: " + pen1.toString());
		pen1.cap();
		System.out.println("1: " + pen1.toString());
		pen1.write();
	}
}
