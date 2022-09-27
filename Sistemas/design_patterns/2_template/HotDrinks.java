import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class HotDrinks {

	public final void boil() {
		System.out.println("Fervendo um pouco de água.");
	}

	public abstract void prepare_infusion();

	public final void serve() {
		System.out.println("Servindo a bebida em uma xícara!");
	}

	public abstract void addFlavorings();

	public boolean wantFlavoring() {
		System.out.printf("Você quer condimentos na sua bebida? (S/n) ");

		try (Scanner keyboard = new Scanner(System.in)) {
			String ans = keyboard.nextLine();

			return ans.toLowerCase().startsWith("s");
		} catch (InputMismatchException e) {
			System.err.println("Not possible to read input.");
			return false;
		}
	}

	public void doDrink() {
		boil();
		prepare_infusion();
		serve();

		if (wantFlavoring())
			addFlavorings();
	}
}
