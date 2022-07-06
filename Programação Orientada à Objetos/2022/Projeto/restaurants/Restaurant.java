package restaurants;

import people.Person;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;

import people.PeopleRepository;

public class Restaurant {
    static private int lastId;
    private int id;
    private String address;
    private String name;
    private String description;

    private Person manager; // Pessoa associada responsável pelo restaurante.
    private Hashtable<Integer, Menu> menus;
    private PeopleRepository clients; // Repositório de pessoas.
    // Filas: Marcam o estado de entrega dos pedidos.
    private LinkedList<Demand> onWait;
    private LinkedList<Demand> onDeliver;

    public class NotRegistered extends Exception {
        NotRegistered(String message) {
            super(message);
        }
    }

    public class EmptyMenu extends Exception {
        EmptyMenu(String message) {
            super(message);
        }
    }

    public Restaurant(String name, String address, Menu[] menus, Person manager) throws EmptyMenu {
        this.id = ++Restaurant.lastId;
        this.name = name;
        this.address = address;
        this.onWait = new LinkedList<Demand>();
        this.onDeliver = new LinkedList<Demand>();
        this.menus = new Hashtable<Integer, Menu>();
        this.clients = new PeopleRepository();
        this.manager = manager;

        for (Menu menu : menus)
            addMenu(menu);

        if (menus.length == 0)
            throw new EmptyMenu(
                    "Restaurant was created with an empty menu, may not operate normally.");
    }

    /*
     * Registra uma pessoa como cliente do restaurante.
     * Deve ser feito uma vez antes de fazer um pedido.
     */
    public void register(Person person) {
        clients.add(person);
    }

    /* Realiza um pedido para a pessoa indicada com base em algum item do menu. */
    public void request(Person person, int menuId) throws NotRegistered {

        if (clients.getPersonById(person.getId()) == null)
            throw new NotRegistered("Person not a registered client.");

        Demand newDemand = new Demand(menuId, person);
        newDemand.setState(Demand.State.ON_WAIT);
        onWait.add(newDemand);
        person.storeDemand(newDemand, this);
    }

    /*
     * Executa a próxima entrega.
     * Se não houver pedidos na fila, ou o mesmo for cancelado, retornará nulo.
     */
    public Demand nextDeliver() {
        Demand next = onWait.pop();

        if (next == null || next.getState() == Demand.State.NONE)
            return null;

        onDeliver.add(next);
        next.setState(Demand.State.ON_DELIVER);
        return next;
    }

    /*
     * Finaliza a próxima entrega.
     * Se não houver pedidos na fila, ou o mesmo for cancelado, retornará nulo.
     */
    public Demand finishDeliver() {
        Demand next = onDeliver.pop();

        if (next == null || next.getState() == Demand.State.NONE)
            return null;

        Restaurant r = next.getOwner().cleanDemand(next);
        assert r == this : "Associated deliver on queue is not this.";

        // Apenas para se certificar, não é estritamente necessário.
        next.setState(Demand.State.NONE);

        return next;
    }

    /* Cancela uma entrega. */
    public void cancelDeliver(Demand demand) {
        demand.setState(Demand.State.NONE);
    }

    /*
     * Adiciona um item ao cardápio.
     * Retorna true se o item for adicionado com sucesso, caso contrário já estava
     * incluso.
     */
    public boolean addMenu(Menu menu) {
        boolean wasAdded = menu.addTo(this);

        if (wasAdded)
            menus.put(menu.getId(), menu);

        return wasAdded;
    }

    /*
     * Remove um item do cardápio.
     * Retorna true se o item for removido com sucesso, caso contrário não estava
     * incluso.
     */
    public boolean removeMenu(Menu menu) {
        boolean wasAdded = menu.removeFrom(this);

        if (wasAdded)
            menus.remove(menu.getId());

        return wasAdded;
    }

    /* Retorna todos os itens do cardápio. */
    public Collection<Menu> getMenus() {
        return menus.values();
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
        return String.format("[%d]: %s, %s", id, name, manager.getName());
    }

}
