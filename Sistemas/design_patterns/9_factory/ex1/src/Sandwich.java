public class Sandwich {

	public enum Bread {
		INTEGRAL,
		FRENCH,
		BALL,
	}

	public enum Ham {
		CHICKEN,
		TURKEY,
	}

	public enum Cheese {
		PLATE,
		MUSSARELA,
		CHEDDAR,
	}

	private static String[] breads = {
			"integral", "francês", "bola",
	};
	private static String[] hams = {
			"frango", "peru",
	};
	private static String[] cheeses = {
			"prato", "cheddar", "mussarela",
	};

	public Bread breadSlice;
	public Cheese cheeseSlice;
	public Ham hamSlice;
	public boolean saladHasVegetable;

	public Sandwich(Bread breadSlice, Cheese cheeseSlice, Ham hamSlice, boolean saladHasVegetable) {
		this.breadSlice = breadSlice;
		this.cheeseSlice = cheeseSlice;
		this.hamSlice = hamSlice;
		this.saladHasVegetable = saladHasVegetable;
	}

	public static String getBreadName(Bread b) {
		return breads[b.ordinal()];
	}

	public static String getCheeseName(Cheese c) {
		return cheeses[c.ordinal()];
	}

	public static String getHamName(Ham h) {
		return hams[h.ordinal()];
	}

	@Override
	public String toString() {
		return String.format("Sanduíche de %s %s salada, com queijo %s e pão %s",
				getHamName(hamSlice), saladHasVegetable ? "com" : "sem",
				getCheeseName(cheeseSlice), getBreadName(breadSlice));
	}
}
