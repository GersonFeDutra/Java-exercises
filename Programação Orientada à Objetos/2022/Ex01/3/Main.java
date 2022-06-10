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

		persons[0].setUniversity(
				new University("Princeton", "New Jersey - USA"),
				"physics teacher");
		persons[1].setUniversity(
				new University("Cambridge", "England"),
				"math teacher");

		for (Person person : persons) {
			System.out.println(person.introduction());
		}

	}

}
