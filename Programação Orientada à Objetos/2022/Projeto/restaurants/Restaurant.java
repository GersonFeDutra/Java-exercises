package restaurants;

import people.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import people.PeopleRepository;

public class Restaurant {
	static private int lastId;
	private int id;
	private String address;
	private String name;
	private String description;
	private MenuRepository menu;
	private MenuRepository juneMenu;

	private PeopleRepository clients; // Repositório de pessoas.
	// Filas: Marcam o estado de entrega dos pedidos.
	private LinkedList<Demand> onWait;
	private LinkedList<Demand> onDeliver;

	public class NotRegistered extends Exception {
		NotRegistered(String message) {
			super(message);
		}
	}

	public class IdNotFound extends Exception {
		IdNotFound(String message) {
			super(message);
		}
	}

	public Restaurant(String name, String address, Menu[] items) {
		this.id = ++Restaurant.lastId;
		this.name = name;
		this.address = address;
		this.onWait = new LinkedList<Demand>();
		this.onDeliver = new LinkedList<Demand>();
		this.clients = new PeopleRepository();
		this.menu = new MenuRepository(this, items);
		this.menu = new MenuRepository(this);
	}

	/*
	 * Registra uma pessoa como cliente do restaurante.
	 * Deve ser feito uma vez antes de fazer um pedido.
	 */
	public void register(Person person) {
		clients.add(person);
	}

	/* Consulta o id de um cliente do restaurante, retornando seu registro. */
	public Person getClientById(int id) {
		return clients.getPersonById(id);
	}

	/*
	 * Consulta o nome dos clientes do restaurante, retornando registros
	 * correspondentes.
	 */
	public ArrayList<Person> getClientsByName(String name) {
		return clients.getPersonsByName(name);
	}

	/*
	 * Remove e retorna registro de um cliente do repositório,
	 * se o mesmo estiver presente; caso contrário, retornará null.
	 */
	public Person removeByID(int id) {
		return clients.removePersonByID(id);
	}

	/*
	 * Remove e retorna um cliente diretamente, se o mesmo estiver presente no
	 * repositório.
	 * Retorna um boolean para indicar o sucesso da operação.
	 */
	public boolean remove(Person person) {
		return clients.remove(person);
	}

	/* Realiza um pedido para a pessoa indicada com base em algum item do menu. */
	public void request(Person person, int menuId) throws NotRegistered {

		if (clients.getPersonById(person.getId()) == null)
			throw new NotRegistered("Person not a registered client.");

		Demand newDemand = new Demand(menuId, person);
		clients.incrementNDemands(person.getId());
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

	/* Retorna todos os pedidos de um dado cliente */
	public Collection<Demand> getRequestsFrom(Person person) {
		return person.getRequestsAt(this);
	}
	
	/*
	 * Retorna o número de pedidos associado a um cliente do restaurante.
	 * Se não for cliente, ou não houver pedidos, retorna 0.
	 */
	public int getNDemands(int id) {
		return clients.getNDemands(id);
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

	public MenuRepository getMenu() {
		return menu;
	}

	public MenuRepository getJuneMenu() {
		return juneMenu;
	}

	@Override
	public String toString() {
		return String.format("[%d]: %s", id, name);
	}

}
