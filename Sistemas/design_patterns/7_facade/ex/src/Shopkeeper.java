public class Shopkeeper {
	private CellStore apple;
	private CellStore samsung;
	private CellStore xiaomi;

	public Shopkeeper() {
		apple = new Apple();
		samsung = new Samsung();
		xiaomi = new Xiaomi();
	}

	public void appleSell() {
		// TODO - Fazer algo interessante aqui, real que funciona. h3h3
		System.out.printf("Comprando com a Apple:\nModelo: %s\tEstoque: %d\tPreço: %.2f\n",
				apple.getModel(), apple.getStorageQuantity(), apple.getPrice());
	}

	public void samsungSell() {
		// TODO - Fazer algo interessante aqui, real que funciona. h3h3
		System.out.printf("Comprando com a Apple:\nModelo: %s\tEstoque: %d\tPreço: %.2f\n",
				samsung.getModel(), samsung.getStorageQuantity(), samsung.getPrice());

	}

	public void xiaomiSell() {
		// TODO - Fazer algo interessante aqui, real que funciona. h3h3
		System.out.printf("Comprando com a Apple:\nModelo: %s\tEstoque: %d\tPreço: %.2f\n",
				xiaomi.getModel(), xiaomi.getStorageQuantity(), xiaomi.getPrice());

	}
}
