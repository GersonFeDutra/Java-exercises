public class Person {
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private int age;
	private String name;
	University university;

	public Person(String name, int birthDay, int birthMonth, int birthYear, int age) {
		this.name = name;
		updateBirth(birthDay, birthMonth, birthYear);
		this.age = age;
	}

	public Person(String name, int birthDay, int birthMonth,
			int birthYear, int day, int month, int year) {
		this.name = name;
		updateBirth(birthDay, birthMonth, birthYear);
		updateAge(day, month, year);
	}

	/*
	 * método que recebe a data atual em dias, mês e anos e calcula
	 * e armazena no atributo idade a idade atual da pessoa.
	 */
	/* private */void updateAge(int day, int month, int year) {
		this.age = year - this.birthYear;

		if (month - this.birthMonth < 0 && day - this.birthDay < 0)
			this.age -= 1;

	}

	/* Retorna o valor da idade. */
	public int getAge() {
		return this.age;
	}

	/* Retorna o nome da pessoa. */
	public String getName() {
		return this.name;
	}

	/*
	 * Recebe dia, mês e ano de nascimento como parâmetros e preenche nos
	 * atributos correspondentes do objeto.
	 */
	public void updateBirth(int day, int month, int year) {
		this.birthDay = day;
		this.birthMonth = month;
		this.birthYear = year;
	}

	public String introduction() {

		if (this.university != null)
			return String.format("My name is %s and I work at the %s.",
					this.name, this.university.getName());
		else
			return String.format("My name is %s, and I don't work at any university.", this.name);
	}
}
