package facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

import people.Individual;
import people.LegalPerson;
import people.PeopleRepository;
import people.Person;
import restaurants.Demand;
import restaurants.Menu;
import restaurants.Restaurant;
import restaurants.Restaurant.NotRegistered;

/* CLI
 * Command Line Interface for the application.
 */
public class CLI {
    private static final String invalidOptMessage = "Opção inexistente!";

    /*
     * Modo de execução automático.
     * Faz as operações determinadas no exercício automaticamente.
     */
    public static void auto(boolean skipPauses) {
        Person person;
        ArrayList<Person> persons;
        Random RNG = new Random();
        Menu[] menus = {
                new Menu("Banquete do deus sol", 16000.0,
                        "Refeição completa para até 11 pessoas contendo ingredientes diversos de todo o mundo."),
                new Menu("Jejum do deus da lua", 1250.0,
                        "Uma ótima escolha para os mais sofisticados, embora seja uma refeição menor, para até 4 pessoas contém ingredientes raríssimos"),
                new Menu("Siesta do deus da chuva", 1010.0,
                        "Uma escolha tropical que consegue incluir diversos elementos em uma explosão de sabores. Até 6 pessoas a refeição."),
                new Menu("Ceia do deus da terra", 850.0,
                        "Contém os ingredientes mais simples dentre as refeições combo da nossa linha de restaurantes. Mas consegue ser muito generosa alimentando até 7 pessoas. Um ótimo custo-benefício."),
                new Menu("Frutas selvagens", 150 / 4),
                new Menu("Frutas de época", 250 / 4),
                new Menu("Frutas comuns", 75.0),
                new Menu("Bebidas exóticas", 150.0),
                new Menu("Bebidas orientais", 250.0),
                new Menu("Bebidas tropicais", 75.0),
        };
        Restaurant restaurant = new Restaurant("El Baratinho",
                "Litoral, Pacífico Leste, Rua: Azulão, Número: 17-q Bairro: Só",
                menus, new Person("Josef Roja", LocalDate.of(1999, 11, 18)));

        /*
         * Cadastro/consulta/remoção das pessoas (cadastre, pelo menos,
         * cinco pessoas físicas e três pessoas jurídicas).
         */

        // Cadastro
        Individual[] individuals = {
                new Individual("Lúcio Dom Márcio", "3-000.000.000 B", LocalDate.of(2002, 5, 5)),
                new Individual("Zé Ronaldo Coronel", "0-320.000.000 B", LocalDate.of(2004, 11, 11)),
                new Individual("Ana Miranda Natália", "0-066.000.000 B", LocalDate.of(2003, 7, 3)),
                new Individual("São Pinóquio De Mira Boa", "0-200.000.000 B", LocalDate.of(2003, 4, 1)),
                new Individual("Vincent Santos Shakespeare II", "0-330.000.000 B", LocalDate.of(2004, 3, 2)),
        }; // Pessoas físicas.
        LegalPerson[] legalPersons = {
                new LegalPerson("Antônio Tonho Servo", "000,100 B:0 0 00 00", LocalDate.of(2005, 12, 24)),
                new LegalPerson("Roberta Nicole", "130,000 00 0B: 00 00", LocalDate.of(1991, 2, 6)),
                new LegalPerson("Francisco Supremo", "094,000 00 0B: 00 00", LocalDate.of(1985, 3, 9)),
        }; // Pessoas jurídicas

        System.out.printf("Cadastrando pessoas no restaurante %s:\n", restaurant.getName());

        // Pessoas físicas:
        pauseLog(skipPauses, "Registrando \"pessoas físicas\":");
        for (Individual individual : individuals) {
            System.out.printf("Registrando: %s\n", individual);
            restaurant.register(individual);
        }

        // Pessoas jurídicas:
        pauseLog(skipPauses, "Registrando \"pessoas jurídicas\":");
        for (LegalPerson legalPerson : legalPersons) {
            System.out.printf("Registrando: %s\n", legalPerson);
            restaurant.register(legalPerson);
        }

        // Consultas
        pauseLog(skipPauses, "Consultando o registro das pessoas no restaurante, aleatoriamente:");
        System.out.println("Consultando uma pessoa legal por id:");
        person = legalPersons[RNG.nextInt(legalPersons.length)];
        System.out.printf("Consultando pessoa de id %d:\n", person.getId());
        person = restaurant.getClientById(person.getId());
        System.out.printf("Pessoa encontrada: %s\n", person.toString());
        System.out.println();

        System.out.println("Consultando \"pessoas físicas\" por nome:");
        person = individuals[RNG.nextInt(individuals.length)];
        System.out.printf("Consultando pessoas de nome %s:\n", person.getName());
        persons = restaurant.getClientsByName(person.getName());

        for (Person _person : persons)
            System.out.printf("Pessoa encontrada: %s\n", _person.toString());

        // Remoções
        pauseLog(skipPauses, "Removendo o registro das pessoas no restaurante, aleatoriamente:");
        System.out.println("Removendo uma \"pessoa física\" por id:");
        person = individuals[RNG.nextInt(individuals.length)];
        System.out.printf("Removendo uma pessoa de id %d:\n", person.getId());
        person = restaurant.removeByID(person.getId());
        System.out.printf("Pessoa removida: %s\n", person.toString());
        System.out.println();

        System.out.println("Removendo \"pessoas físicas\" de forma direta:");
        person = legalPersons[RNG.nextInt(legalPersons.length)];
        System.out.printf("Removendo <%s> dos registros do restaurante:\n", person.toString());

        if (restaurant.remove(person))
            System.out.printf("%s removido(a) com sucesso!\n", person.getName());

        /*
         * Mostrar todos os itens que estão no cardápio.
         */

        System.out.println();
        pauseLog(skipPauses, String.format(
                "Listando os itens do cardápio do restaurante %s", restaurant.getName()));
        Collection<Menu> itens = restaurant.getMenus();

        System.out.println(String.format("%22s | %6s | Descrição", "Nome", "Valor"));
        for (Menu item : itens)
            System.out.println(String.format("%22s | %6s | %s",
                    item.getProduct(), item.getValue(), item.getDescription()));

        /*
         * Cadastro/consulta de todos os restaurantes.
         */
        Restaurant[] restaurants = {
                restaurant,
                new Restaurant("Siri cascudo", "Fenda do Biquíni, Triângulo das Bermudas, Rua: Esquina comercial",
                        menus, new Person("Seu Sirigueijo", LocalDate.of(1980, 10, 11))),
                new Restaurant("Papa's restaurant", "França, Beco dos Cones, Rua: Avenida dos chapéus, Número: 804",
                        menus, new Person("Papa MakerMan", LocalDate.of(1979, 01, 23))),
                new Restaurant("TorikoLand", "Novo Mundo, Ala 2, Floresta encantada, Rua: encontro dos sabores.",
                        menus, new Person("Toriko", LocalDate.of(1995, 07, 03))),
        };

        pauseLog(skipPauses, "Restaurantes criados:");
        System.out.println(String.format("%22s | %6s | Endereço", "Nome", "Gerente"));
        for (Restaurant _restaurant : restaurants) {
            System.out.printf("%22s | %6s | %s",
                    _restaurant.getName(), _restaurant.getManagerName(), _restaurant.getAddress());
        }

        /*
         * Pesquisa os pedidos realizados por uma determinada pessoa jurídica em um
         * restaurante específico.
         * &
         * Realiza o cadastro de um pedido com três itens do cardápio de um determinado
         * restaurante.
         */

        // Fazendo os pedidos:
        pauseLog(skipPauses, "Fazendo os pedidos:");

        for (int i = 0; i < 3; ++i) {
            try {
                restaurant.request(individuals[i], menus[i].getId());
                System.out.printf("<%s> requisitou o pedido <%s>.\n", individuals[i].toString(), menus[i].toString());
            } catch (NotRegistered e) {
                System.out.printf("<%s> não registrado no restaurante <%s>.\n",
                        individuals[i].toString(), restaurant);
            }
        }
        for (int i = 0; i < 2; ++i) {
            // Os itens do menu são equivalentes a um único Demand, logo 3 itens = 3
            // Demands.
            try {
                restaurant.request(legalPersons[i], menus[i].getId());
                System.out.printf("<%s> requisitou o pedido <%s>.\n", legalPersons[i].toString(), menus[i].toString());
                restaurant.request(legalPersons[i], menus[menus.length - i - 1].getId());
                System.out.printf("<%s> também requisitou <%s>.\n", legalPersons[i].toString(), menus[i].toString());
                restaurant.request(legalPersons[i], menus[menus.length - i - 2].getId());
                System.out.printf("<%s> também requisitou <%s>.\n", legalPersons[i].toString(), menus[i].toString());
            } catch (NotRegistered e) {
                System.out.printf("<%s> não registrado no restaurante <%s>.\n",
                        legalPersons[i].toString(), restaurant);
            }
        }

        // Buscando o pedido:
        pauseLog(skipPauses, String.format(
                "Verificando os pedido de <%s> no restaurante %s:",
                legalPersons[0].toString(), restaurant.toString()));
        Collection<Demand> demands = restaurant.getRequestsFrom(legalPersons[0]);

        if (demands != null)
            for (Demand _demand : demands)
                System.out.printf("Pedido <%s>: %s.\n", _demand.getId(),
                        restaurant.getMenu(_demand.getId()).toString());
    }

    public static void pauseLog(boolean skipPauses, String message) {
        System.out.println();
        System.out.println(message);
        if (skipPauses)
            return;
        System.out.println("Pressione Enter para continuar...");

    }

    public static void pause(boolean skipPauses) {
        System.out.println();
        if (skipPauses)
            return;
        System.out.println("Pressione Enter para continuar...");

    }

    /*
     * Modo de execução manual.
     * Faz as operações na Interface de Linha de Comando (CLI)
     * utilizando prompts a cada passo/ operação.
     */
    public static void manual(Scanner scanner) {

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
    }

    private static void menu(boolean enableOpt3) {
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

        return new Restaurant(name, address, (Menu[]) defaultMenu.values().toArray(), manager);
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

                    newMenu = new Menu(value, name, null);
                    if (newMenu != null) {
                        menu.put(newMenu.getId(), newMenu);

                        if (!description.isBlank())
                            newMenu.setDescription(description);

                        System.out.println("Product created!");
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
