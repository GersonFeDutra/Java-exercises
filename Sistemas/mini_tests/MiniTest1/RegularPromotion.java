/* Promoção feita à vista. */
public class RegularPromotion extends Promotion {

	@Override
	double calculate(double value) {
		return value - value * 0.05;
	}

}
