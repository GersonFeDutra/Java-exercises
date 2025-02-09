package factories;
import ingredients.breads.Ball;
import ingredients.cheeses.Cheddar;
import ingredients.hams.Turkey;

public class SandwichIngredientsFactoryBarbalha implements SandwichIngredientsFactory {
    @Override
    public Sandwich createSandwich() {
        return new Sandwich(new Ball(), new Cheddar(), new Turkey(), false);
    }
}
