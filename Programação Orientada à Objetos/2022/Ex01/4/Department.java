import java.util.ArrayList;

public class Department {
	String name;
	private ArrayList<Person> functionaries;

	public Department(String name) {
		this.name = name;
		this.functionaries = new ArrayList<Person>();
	}

	public void addFunctionary(Person person) {
		if (functionaries.contains(person))
			return;
		functionaries.add(person);
	}

	public void removeFunctionary(Person person) {
		functionaries.remove(person);
	}

	public Person getFunctionary(String name) {
		for (Person functionary : functionaries)
			if (functionary.getName() == name)
				return functionary;

		return null;
	}

}
