/**
 * Tea
 */
public class Tea extends HotDrinks {

	@Override
	public void prepare_infusion() {
		System.out.println("Submergindo o chá na água fervendo.");
	}

	@Override
	public void addFlavorings() {
		System.out.println("Adicionar limão.");
	}
}
