import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		int d = now.getDayOfMonth();
		int m = now.getMonthValue();
		int y = now.getYear();

		Person persons[] = {
				new Person("Albert Einstein", 14, 3, 1879, d, m, y),
				new Person("Isaac Newton", 4, 1, 1643, d, m, y),
		};
		University universities[] = {
				new University("Princeton", "New Jersey - USA"),
				new University("Cambridge", "England"),
		};
		Department departments[] = {
				new Department("physics"),
				new Department("math"),
		};

		for (int i = 0; i < 2; ++i) {
			universities[i].addDepartment(departments[i]);
			persons[i].setUniversity(universities[i], departments[i], "teacher");
			System.out.println(persons[i].introduction());
		}

	}

}
