public class Xiaomi implements CellStore {

	@Override
	public double getPrice() {
		return 10d;
	}

	@Override
	public String getModel() {
		return "Xingling";
	}

	@Override
	public int getStorageQuantity() {
		return (int) Double.POSITIVE_INFINITY;
	}

}
