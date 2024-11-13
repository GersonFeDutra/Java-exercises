public class ChocolateBoiler {

	private static final ChocolateBoiler boiler = new ChocolateBoiler(); // Inicialização rápida.
	private boolean empty;
	private boolean boiled;

	public static ChocolateBoiler getInstance() {
		return boiler;
	}

	// Só é iniciado quando a caldeira está vazia.
	private ChocolateBoiler() {
		this.empty = true;
		this.boiled = true;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			System.out.println("Preenchendo a caldeira com uma mistura de leite e chocolate.");
		}
	}

	// Para drenar a caldeira ela deve estar cheia e também em ebulição.
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			System.out.println("Drena o leite e o chocolate fervidos.");
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			System.out.println("Colocando o conteúdo em ebulição.");
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
