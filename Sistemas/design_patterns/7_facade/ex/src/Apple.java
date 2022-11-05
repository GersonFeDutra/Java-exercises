public class Apple implements CellStore {

	@Override
	public double getPrice() {
		return 1000000d;
	}

	@Override
	public String getModel() {
		return "Paia e Caro";
	}

	@Override
	public int getStorageQuantity() {
		return 2;
	}
}
