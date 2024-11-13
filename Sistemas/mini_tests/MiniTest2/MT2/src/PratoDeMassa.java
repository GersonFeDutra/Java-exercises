public abstract class PratoDeMassa {

	public final void fazerReceitaTemplate() {
		ferverAgua();
		cozinharMassa();
		escorrerMassa();
		colocarNoPrato();
		adicionarMassa();
		adicionarMolho();
		adicionarProteina();
		adicionarEnfeite();
		System.out.println();
	}

	public void ferverAgua() {
		System.out.println("Fervendo a água!");
	}

	public void cozinharMassa() {
		System.out.println("Cozinhando a massa!");
	}

	public void escorrerMassa() {
		System.out.println("Escorrendo a massa!");
	}

	public void colocarNoPrato() {
		System.out.println("Colocando no prato!");
	}

	public abstract void adicionarMassa();

	public abstract void adicionarMolho();

	public abstract void adicionarProteina();

	public abstract void adicionarEnfeite();

}
