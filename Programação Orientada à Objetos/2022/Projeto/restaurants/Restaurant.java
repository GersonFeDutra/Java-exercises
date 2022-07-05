package restaurants;

import people.Person;
import people.PeopleRepository;

public class Restaurant {
    static private final int MAX_MENUS = 7;
    static private int lastId;
    private int id;
    private int currentMenu;
    private int lastTicketId;
    private String address;
    private String name;
    private String description;
    private Menu[] menus;
    private PeopleRepository clients;

    public Restaurant(String name, String address) {
        this.id = ++Restaurant.lastId;
        this.name = name;
        this.address = address;
        clients = new PeopleRepository();
        menus = new Menu[MAX_MENUS];
    }

    public void register(Person person) {
        clients.add(person);
        // O ticket provavelmente terá um pedido (prato) associado.
        person.setTicket(new Ticket(++lastTicketId));
    }

    public void setMenu(Menu menu, int at) {
        menus[at] = menu;
    }

    public Menu getMenu() {
        return menus[currentMenu];
    }

    public void setCurrentMenu(int at) {
        this.currentMenu = at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("[%d]: %s", id, name);
    }

}
