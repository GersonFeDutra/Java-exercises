public class SandwichFactory {

	Sandwich makeSandwich(From from) {
		switch (from) {
			case JUAZEIRO:
				return new Sandwich(
						Sandwich.Bread.INTEGRAL,
						Sandwich.Cheese.PLATE,
						Sandwich.Ham.CHICKEN, false);
			case CRATO:
				return new Sandwich(
					Sandwich.Bread.FRENCH,
					Sandwich.Cheese.MUSSARELA,
					Sandwich.Ham.CHICKEN, true);
			case BARBALHA:
				return new Sandwich(
					Sandwich.Bread.BALL,
					Sandwich.Cheese.CHEDDAR,
					Sandwich.Ham.TURKEY, false);
		}
		return null;
	}
}
