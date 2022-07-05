package people;

import java.util.ArrayList;
import java.util.Hashtable;

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

    public void add(Person person) {
        String name = person.getName();
        ArrayList<Person> people;
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
