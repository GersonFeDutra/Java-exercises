public class NullPromotion extends Promotion {

	@Override
	double calculate(double value) {
		return value;
	}

}
