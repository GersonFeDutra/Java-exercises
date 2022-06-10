import java.util.ArrayList;

public class University {
	private String name;
	private String location;
	private ArrayList<Department> departments;

	public University(String name, String location) {
		this.name = name;
		this.location = location;
		this.departments = new ArrayList<Department>();
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void addDepartment(Department department) {
		if (!departments.contains(department))
			departments.add(department);
	}

	public void removeDepartment(Department department) {
		departments.remove(department);
	}

	public Department getDepartment(String name) {
		for (Department department : departments) {
			if (department.name == name)
				return department;
		}
		return null;
	}

	public void addFunctionary(Person functionary, Department department) throws RuntimeException {
		if (departments.contains(department))
			department.addFunctionary(functionary);
		else
			throw new RuntimeException("Department do not exists.");

	}

}
