package factories;
import ingredients.breads.Integral;
import ingredients.cheeses.Plate;
import ingredients.hams.Chicken;

public class SandwichIngredientsFactoryJuazeiro implements SandwichIngredientsFactory {
    @Override
    public Sandwich createSandwich() {
        return new Sandwich(new Integral(), new Plate(), new Chicken(), false);
    }
}
