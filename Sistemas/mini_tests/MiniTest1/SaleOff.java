/* Liquidação */
public class SaleOff extends Promotion {

	@Override
	double calculate(double value) {
		return value - value * 0.30;
	}

}
