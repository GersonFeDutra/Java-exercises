package factories;
import ingredients.IBread;
import ingredients.ICheese;
import ingredients.IHam;

public class Sandwich {

	public IBread breadSlice;
	public ICheese cheeseSlice;
	public IHam hamSlice;
	public boolean saladHasVegetable;

	public Sandwich(IBread breadSlice, ICheese cheeseSlice, IHam hamSlice, boolean saladHasVegetable) {
		this.breadSlice = breadSlice;
		this.cheeseSlice = cheeseSlice;
		this.hamSlice = hamSlice;
		this.saladHasVegetable = saladHasVegetable;
	}

	@Override
	public String toString() {
		return String.format("Sanduíche de %s %s salada, com queijo %s e pão %s",
				hamSlice.getName(), saladHasVegetable ? "com" : "sem",
				cheeseSlice.getName(), breadSlice.getName());
	}
}
