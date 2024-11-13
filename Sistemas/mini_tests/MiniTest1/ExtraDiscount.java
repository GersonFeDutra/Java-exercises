/*
 *  Desconto à Vista
 */
public class ExtraDiscount extends Promotion {

	private final double MIN_DISCOUNT = 0.05;
	private final double MAX_DISCOUNT = 0.15;

	private double currentDiscount;

	public double getCurrentDiscount() {
		return this.currentDiscount;
	}

	/*
	 * Varia do intervalo entre 5 à 15%.
	 */
	public void setCurrentDiscount(double currentDiscount) {
		this.currentDiscount = currentDiscount;

		if (currentDiscount > MAX_DISCOUNT)
			this.currentDiscount = MAX_DISCOUNT;

		if (currentDiscount < MIN_DISCOUNT)
			this.currentDiscount = MIN_DISCOUNT;
	}

	@Override
	double calculate(double value) {
		return value - value * this.currentDiscount;
	}

}
