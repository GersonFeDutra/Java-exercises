public class Coffee extends HotDrinks {

	@Override
	public void prepare_infusion() {
		System.out.println("Submergindo o café na água fervendo.");
	}

	@Override
	public void addFlavorings() {
		System.out.println("Adicionando açúcar e leite.");
	}

}
