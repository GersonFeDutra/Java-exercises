package factories;
import ingredients.breads.French;
import ingredients.cheeses.Mussarela;
import ingredients.hams.Chicken;

public class SandwichIngredientsFactoryCrato implements SandwichIngredientsFactory {
    @Override
    public Sandwich createSandwich() {
        return new Sandwich(new French(), new Mussarela(), new Chicken(), false);
    }
}
