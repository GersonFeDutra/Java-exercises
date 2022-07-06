import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import people.PeopleRepository;
import people.Person;
import restaurants.Menu;
import restaurants.Restaurant;
import restaurants.Menu.NoRestaurant;
import restaurants.Restaurant.EmptyMenu;

/**
 * Main
 */
public class Main {
    private static final String invalidOptMessage = "Opção inexistente!";

    public static void main(String[] args) {
        cli();
    }

    /* Command Line Interface for the application. */
    public static void cli() {
        Scanner scanner = new Scanner(System.in);

        int opt = 0;
        PeopleRepository people = new PeopleRepository();
        PeopleRepository managers = new PeopleRepository();
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        // Permitir acessar globalmente todos os menus de todos os restaurantes?
        // Seria mais eficiente usar um banco de dados para gerenciar isso.
        // Hashtable<Integer, Menu> allMenus = new Hashtable<Integer, Menu>();
        // Alternativamente mantive um único menu compartilhado com `defaultMenu`.
        Hashtable<Integer, Menu> defaultMenu = new Hashtable<Integer, Menu>();
        // Restaurantes que usarem defaultMenu ainda poderão
        // ter seus menus alterados individualmente.

        do {
            boolean enableTransferOpt = !(people.isEmpty() && restaurants.isEmpty() && defaultMenu.isEmpty());
            menu(enableTransferOpt);
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    people.add(promptNewPerson(scanner));
                    break;
                case 2:
                    restaurants.add(promptNewRestaurant(defaultMenu, managers, scanner));
                    break;
                case 3:
                    updateMenu(defaultMenu, scanner);
                    break;
                case 4:
                    if (enableTransferOpt)
                        transfer(people, restaurants, scanner);
                    break;
                default:
                    System.out.println(invalidOptMessage);
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

        printOptMenuFooter();
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
        System.out.printf("Month: ");
        birthMonth = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Year: ");
        birthYear = scanner.nextInt();
        scanner.nextLine();

        return new Person(name, LocalDate.of(birthYear, birthMonth, birthDay));
    }

    private static Restaurant promptNewRestaurant(
            Hashtable<Integer, Menu> defaultMenu, PeopleRepository managers, Scanner scanner) {
        String name;
        String address;
        Hashtable<Integer, Menu> menu = defaultMenu;
        Restaurant newRestaurant = null;

        System.out.printf("Insert restaurant name: ");
        name = scanner.nextLine();
        System.out.printf("Insert restaurant address: ");
        address = scanner.nextLine();

        Person manager = null;

        boolean hasManagers = !managers.isEmpty();
        if (hasManagers) {
            do {
                System.out.printf("New manager? (y/ N) ");

                if (scanner.nextLine().toLowerCase().startsWith("y")) {
                    break;
                } else {
                    System.out.println("Select manager id: ");
                    printPeople(managers);
                    manager = managers.getPersonById(scanner.nextInt());
                    scanner.nextLine();
                }
            } while (manager == null);
        }
        if (manager == null)
            manager = promptNewPerson(scanner);

        System.out.printf("Manager %s selected!\n", manager.toString());

        System.out.printf("Use default menu (Y/ n): ");
        if (scanner.nextLine().toLowerCase().startsWith("n")) {
            // use custom
            System.out.printf("Select a initial menu for the restaurant: ");
            menu = new Hashtable<Integer, Menu>();
            updateMenu(menu, scanner);
        } // else: use default

        try {
            newRestaurant = new Restaurant(name, address, (Menu[]) defaultMenu.values().toArray(), manager);
        } catch (EmptyMenu e) {
            System.out.println("Waring! restaurant has an empty menu. Will not operate properly.");
        }

        return newRestaurant;
    }

    /* Função auxiliar para atualizar o cardápio indicado. */
    private static void updateMenu(Hashtable<Integer, Menu> menu, Scanner scanner) {
        System.out.printf("%s the menu:\n", menu.isEmpty() ? "Create" : "Update");
        int opt = 0;

        do {
            System.out.println("1 - Create item");
            System.out.println("2 - Remove item");
            System.out.println("3 - Update item");
            System.out.println("4 - Delete item");
            printOptMenuFooter();
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 0:
                    break;
                case 1: {
                    System.out.printf("Product name: ");
                    String name = scanner.nextLine();
                    System.out.printf("Product value: R$ ");
                    double value = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.printf("Product description (optional - enter for none): ");
                    String description = scanner.nextLine();
                    Menu newMenu = null;

                    try {
                        newMenu = new Menu(value, name, null);
                    } catch (NoRestaurant e) {
                    } finally {
                        if (newMenu != null) {
                            menu.put(newMenu.getId(), newMenu);

                            if (!description.isBlank())
                                newMenu.setDescription(description);

                            System.out.println("Product created!");
                        }
                    }
                }
                    break;
                case 2: {
                    System.out.printf("Product id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Menu item = menu.remove(id);

                    if (item != null)
                        System.out.printf("Item <%s> removido com sucesso!\n", item.toString());
                    else
                        System.out.println("Item não encontrado!");
                }
                    break;
                case 3: {
                    System.out.printf("Product id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Menu item = menu.get(id);

                    do {
                        System.out.println("What to change:");
                        System.out.println("1 - Name");
                        System.out.println("2 - Price");
                        System.out.println("3 - Description");
                        printOptMenuFooter();
                        opt = scanner.nextInt();
                        scanner.nextLine();

                        switch (opt) {
                            case 0:
                                break;
                            case 1: {
                                System.out.printf("Nem name: ");
                                item.setProduct(scanner.nextLine());
                            }
                                break;
                            case 2: {
                                System.out.printf("New price: ");
                                item.setValue(scanner.nextDouble());
                            }
                                break;
                            case 3: {
                                System.out.printf("New description: ");
                                item.setDescription(scanner.nextLine());
                            }
                            default:
                                System.out.println(invalidOptMessage);
                        }

                    } while (opt != 0);
                    opt = 3; // Retorna o estado da variável reciclada.
                }
                    break;
                default:
                    System.out.println(invalidOptMessage);
            }
        } while (opt != 0);
    }

    /*
     * Função auxiliar para realizar uma transferência.
     * Requisitos:
     * people não pode estar vazio.
     * restaurants não pode ser vazio.
     */
    private static void transfer(
            PeopleRepository people, ArrayList<Restaurant> restaurants, Scanner scanner) {
        assert (people.getSize() != 0) : "people should not be an empty repository.";
        assert (restaurants.size() != 0) : "restaurants should not be an empty list.";

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

    /* Método auxiliar para imprimir o rodapé de um dado menu de opções. */
    private static void printOptMenuFooter() {
        System.out.println("0 - Exit");
        System.out.printf(">>> ");
    }

    private static void printPeople(PeopleRepository people) {
        for (Person person : people.getPeople())
            System.out.println(person.toString());
    }
}
