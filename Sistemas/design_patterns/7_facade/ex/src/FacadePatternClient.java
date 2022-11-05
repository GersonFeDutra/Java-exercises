import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FacadePatternClient {
	private static int option;

	public static void main(String args[]) {
		do {
			System.out.print("========= Mobile Shop ============ \n");
			System.out.print("1. APPLE.              \n");
			System.out.print("2. SAMSUNG.              \n");
			System.out.print("3. XIAOMI.                 \n");
			System.out.print("4. Exit.                   \n");
			System.out.print("Enter your choice: ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			Shopkeeper shopKeeper = new Shopkeeper();

			switch (option) {
				case 1: shopKeeper.appleSell(); break;
				case 2: shopKeeper.samsungSell(); break;
				case 3: shopKeeper.xiaomiSell(); break;
				default: System.out.println("Opção inválida!"); return;
			}
		} while (option != 4);
	}
}
