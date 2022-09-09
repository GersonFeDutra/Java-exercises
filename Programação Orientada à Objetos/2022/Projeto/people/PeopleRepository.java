package people;

import java.util.ArrayList;
import java.util.Hashtable;

/*
 * PeopleRepository
 * Um repositório de pessoas.
 * Classe repositório auxiliar para lidar com um conjunto de Person.
 */
public class PeopleRepository {
	private ArrayList<Person> people;
	private Hashtable<Integer, Person> idMap;
	private Hashtable<String, ArrayList<Person>> nameMap;
	// Associa uma pessoa a quantidade de pedidos feitos.
	private Hashtable<Integer, Integer> demandsNMap;

	public PeopleRepository() {
		this.people = new ArrayList<Person>();
		this.idMap = new Hashtable<Integer, Person>();
		this.nameMap = new Hashtable<String, ArrayList<Person>>();
		this.demandsNMap = new Hashtable<Integer, Integer>();
	}

	/*
	 * Verifica o repositório por uma pessoa com o id indicado.
	 * Retorna null se não for encontrado.
	 */
	public Person getPersonById(int id) {
		return idMap.getOrDefault(id, null);
	}

	/*
	 * Retorna uma lista de pessoas com os nomes determinados.
	 */
	public ArrayList<Person> getPersonsByName(String name) {
		return nameMap.get(name);
	}

	/*
	 * Adiciona uma pessoa no repositório.
	 * Se a pessoa já estiver registrada, não será inserida novamente.
	 */
	public void add(Person person) {
		String name = person.getName();
		ArrayList<Person> people;

		if (idMap.containsKey(person.getId()))
			return;

		this.people.add(person);

		if (nameMap.containsKey(name))
			people = nameMap.get(name);
		else {
			people = new ArrayList<Person>();
			nameMap.put(name, people);
		}
		people.add(person);
		idMap.put(person.getId(), person);
	}

	/*
	 * Remove uma pessoa do repositório.
	 * Retorna falso se a pessoa não estiver presente.
	 */
	public boolean remove(Person person) {
		if (person == null || !idMap.containsKey(person.getId()))
			return false;

		ArrayList<Person> people = nameMap.get(person.getName());
		people.remove(person);
		idMap.remove(person.getId());

		return this.people.remove(person);
	}

	/*
	 * Busca e remove uma pessoa do repositório com o id indicado.
	 * Se não for encontrada, retorna null.
	 */
	public Person removePersonByID(int id) {
		Person person = idMap.getOrDefault(id, null);

		if (remove(person))
			return person;

		return null;
	}

	/* Incrementa um pedido feito por uma pessoa neste repositório. */
	public void incrementNDemands(int id) {
		if (!idMap.containsKey(id))
			return;

		int counter = 0;

		if (!demandsNMap.containsKey(id))
			demandsNMap.put(id, 0);
		else
			counter = demandsNMap.get(id);

		demandsNMap.replace(id, counter + 1);
	}

	/*
	 * Retorna a quantidade de pedidos feito por uma pessoa associada a este
	 * repositório.
	 * Retorno 0 se a pessoa não tiver feito pedidos ou não estiver presente.
	 */
	public int getNDemands(int id) {
		return demandsNMap.getOrDefault(id, 0);
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public boolean isEmpty() {
		return people.isEmpty();
	}

	public int getSize() {
		return people.size();
	}

}
