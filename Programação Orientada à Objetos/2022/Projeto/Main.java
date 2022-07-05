import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import people.PeopleRepository;
import people.Person;
import restaurants.Restaurant;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        cli();
    }

    /* Command Line Interface for the application. */
    public static void cli() {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        PeopleRepository people = new PeopleRepository();
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        do {
            boolean enableOpt3 = !(people.isEmpty() && restaurants.isEmpty());
            menu(enableOpt3);
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    people.add(promptNewPerson(scanner));
                    break;
                case 2:
                    restaurants.add(promptNewRestaurant(scanner));
                    break;
                case 3:
                    if (enableOpt3)
                        transfer(people, restaurants, scanner);
                    break;
                default:
                    System.out.println("Opção inexistente!");
            }
        } while (opt != 0);

        if (scanner != null)
            scanner.close();
    }

    public static void menu(boolean enableOpt3) {
        System.out.println("1 - Create Person");
        System.out.println("2 - Create Restaurant");

        if (enableOpt3)
            System.out.println("3 - Person > Restaurant");

        System.out.println("0 - Exit");
        System.out.printf(">>> ");
    }

    private static Person promptNewPerson(Scanner scanner) {
        int birthDay;
        int birthMonth;
        int birthYear;
        String name;

        System.out.printf("Insert person name: ");
        name = scanner.nextLine();

        System.out.println("Insert person birth date:");
        System.out.printf("Day: ");
        birthDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Month: ");
        birthMonth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Year: ");
        birthYear = scanner.nextInt();
        scanner.nextLine();

        return new Person(name, LocalDate.of(birthYear, birthMonth, birthDay));
    }

    private static Restaurant promptNewRestaurant(Scanner scanner) {
        String name;
        String address;

        System.out.println("Insert restaurant name: ");
        name = scanner.nextLine();
        System.out.println("Insert restaurant address: ");
        address = scanner.nextLine();

        return new Restaurant(name, address);
    }

    /* Função auxiliar para realizar uma transferência.
     * Requisitos:
     *     people não pode estar vazio.
     *     restaurants não pode ser vazio.
     */
    private static void transfer(
            PeopleRepository people, ArrayList<Restaurant> restaurants, Scanner scanner) {
        // Essa função só deve ser chamada se a lista e o repositório passados não estiverem vazios.
        assert(restaurants.size() != 0);
        assert(people.getSize() != 0);

        int id;
        Person person = null;
        Restaurant restaurant = null;
        System.out.println("Choose a person: ");
        ArrayList<Person> persons = people.getPeople();

        for (Person _person : persons)
            System.out.println(_person.toString());

        do {
            System.out.printf(">>> ");
            id = scanner.nextInt();
            scanner.nextLine();
            person = people.getPersonById(id);

            if (person == null)
                System.out.println("Erro, id inexistente!");
            else
                break;

        } while (true);

        System.out.println("Choose a restaurant: ");

        for (Restaurant _restaurant : restaurants)
            System.out.println(_restaurant.toString());

        do {
            System.out.printf(">>> ");
            id = scanner.nextInt();
            scanner.nextLine();

            boolean wasFound = false;

            for (Restaurant _restaurant : restaurants) {
                if (_restaurant.getId() == id) {
                    restaurant = _restaurant;
                    wasFound = true;
                    break;
                }
            }

            if (wasFound)
                break;
            else
                System.out.println("Erro, id inexistente!");

        } while (true);


        restaurant.register(person);
        System.out.println("Pessoa registrada com sucesso no restaurante.");
    }
}
