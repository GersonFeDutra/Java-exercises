package restaurants;

import java.util.Collection;
import java.util.Hashtable;

/*
 * MenuRepository
 * Classe que armazena diversos itens de Menu formando um cardápio.
 */
public class MenuRepository {
	// O restaurante ao qual esse cardápio pertence.
	private Restaurant owner;
	private Hashtable<Integer, Menu> items;

	MenuRepository(Restaurant owner) {
		this.owner = owner;
		this.items = new Hashtable<Integer, Menu>();
	}

	MenuRepository(Restaurant owner, Menu[] items) {
		this.owner = owner;
		this.items = new Hashtable<Integer, Menu>();

		for (Menu item : items) {
			addMenu(item);
		}
	}

	/*
	 * Adiciona um item ao cardápio.
	 * Retorna true se o item for adicionado com sucesso, caso contrário já estava
	 * incluso.
	 */
	public boolean addMenu(Menu item) {
		boolean wasAdded = item.addTo(owner);

		if (wasAdded)
			items.put(item.getId(), item);

		return wasAdded;
	}

	/*
	 * Remove um item do cardápio.
	 * Retorna true se o item for removido com sucesso, caso contrário não estava
	 * incluso.
	 */
	public boolean removeMenu(Menu item) {
		boolean wasAdded = item.removeFrom(owner);

		if (wasAdded)
			items.remove(item.getId());

		return wasAdded;
	}

	/* Retorna um item do cardápio com base no id passado. */
	public Menu getItem(int id) {
		return items.getOrDefault(id, null);
	}

	/* Retorna todos os itens do cardápio. */
	public Collection<Menu> getItems() {
		return items.values();
	}
}
