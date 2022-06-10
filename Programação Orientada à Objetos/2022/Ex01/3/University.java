import java.util.ArrayList;

public class University {
	private String name;
	private String location;
	private ArrayList<Person> teachers;

	public University(String name, String location) {
		this.name = name;
		this.location = location;
		this.teachers = new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void addTeacher(Person person) {
		if (teachers.contains(person))
			return;
		teachers.add(person);
	}

	public void removeTeacher(Person person) {
		teachers.remove(person);
	}

}
