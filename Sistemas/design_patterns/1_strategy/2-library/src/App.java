import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import library.Article;
import library.Library;
import library.items.Item;

public class App {
    public static void main(String[] args) {

        Library lib = new Library();
        System.out.println("Welcome to our library, what session would you like to visit?");
        String[] sessions = lib.getSessions();

        int i = 0;
        for (String session : sessions)
            System.out.printf("%d - %s\n", i++, session);

        int opt;
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.printf(">>> ");
            opt = keyboard.nextInt();
            keyboard.nextLine();

            Article article;
            String session = "";
            try {
                session = sessions[opt];
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Session not Found!");
            }

            for (;;) {
                System.out.printf("Do you want to get an item? (Y/n) ");
                if (keyboard.nextLine().toLowerCase().startsWith("n")) {
                    System.out.println("See ya!");
                    return;
                }
                article = lib.getArticle(session);
                ArrayList<Item> items = article.getItemsList();

                System.out.println("----------------------------------------");
                for (Item item : items) {
                    System.out.printf("%d [%s] - %s\n",
                            item.getId(), item.toString(), item.getTitle());
                }
                System.out.printf("Select an item: ");
                opt = keyboard.nextInt();
                keyboard.nextLine();

                Item selected = article.getItem(opt);
                System.out.printf("The %s \"%s\" costs: %.2f\n",
                        selected.toString(), selected.getTitle(), selected.getPrice());
            }
        } catch (InputMismatchException e) {
            System.err.println("Input error! Exiting...");
            System.err.println(e);
        }
    }
}
