package factories;
public class SandwichFactory {
	public enum From {
		JUAZEIRO,
		CRATO,
		BARBALHA,
	}

	private SandwichIngredientsFactory[] factories = {
		new SandwichIngredientsFactoryJuazeiro(),
		new SandwichIngredientsFactoryCrato(),
		new SandwichIngredientsFactoryBarbalha(),
	};

	public Sandwich makeSandwich(From from) {
		return factories[from.ordinal()].createSandwich();
	}
}
