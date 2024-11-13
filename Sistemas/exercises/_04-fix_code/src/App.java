import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            int code;
            System.out.printf("Informe o código: ");
            code = keyboard.nextInt();

            // Opção correta
            while (code != -1) {
                System.out.println("Código: " + code);
                System.out.printf("Informe o código: ");

                try {
                    code = keyboard.nextInt();
                } catch (InputMismatchException e) {
                    continue;
                }
            }

            // Opção corrigida
            do {
                System.out.printf("Informe o código: ");
                try {
                    code = keyboard.nextInt();
                } catch (InputMismatchException e) {
                    continue;
                }
                if (code == -1)
                    break;
                System.out.println("Código: " + code);
            } while (true);
        }
    }

}
