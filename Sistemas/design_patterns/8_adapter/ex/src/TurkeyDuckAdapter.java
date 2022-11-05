public class TurkeyDuckAdapter implements Duck {
	Turkey turkey;

	public TurkeyDuckAdapter() {
		turkey = new Turkey();
	}

	@Override
	public void fly() {
		turkey.swingWings();
	}

	@Override
	public void honk() {
		turkey.wooble();
	}

}
