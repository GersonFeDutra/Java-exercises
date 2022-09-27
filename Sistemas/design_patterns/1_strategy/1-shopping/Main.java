import java.util.InputMismatchException;
import java.util.Scanner;

import shippings.*;

public class Main {

	public static void main(String[] args) {
		Shopping shopping = new Shopping();
		System.out.println("Welcome! In which enterprise would you like to make the shipping?");

		// Print opts
		int i = 0;
		for (Shipping opt: shopping.getShippingOpts())
			System.out.printf("%d - %s\n", i++, opt.toString());

		// Select opt
		System.out.printf(">>> ");
		try (Scanner keyboard = new Scanner(System.in)) {
			try {
				int opt = keyboard.nextInt();
				shopping.setShippingStrategy(opt);
			} catch (InputMismatchException e) {
				System.err.println("Invalid selection!");
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		// Shipping
		Shipping shipping = shopping.getStrategy();
		System.out.printf("Doing a shipping with %s. The value of the shipping is $%.2f.\n",
				shipping.toString(), shipping.doShip());

	}
}
