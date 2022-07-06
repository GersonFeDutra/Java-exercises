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

    public PeopleRepository() {
        this.people = new ArrayList<Person>();
        this.idMap = new Hashtable<Integer, Person>();
        this.nameMap = new Hashtable<String, ArrayList<Person>>();
    }

    public Person getPersonById(int id) {
        return idMap.getOrDefault(id, null);
    }

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
        if (!idMap.containsKey(person.getId()))
            return false;
        ArrayList<Person> people = nameMap.get(person.getName());

        people.remove(person);
        idMap.remove(person.getId());

        return this.people.remove(person);
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
