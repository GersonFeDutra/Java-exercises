/*
 * Exercício 6 - Identifique as classes e implemente um programa para
 * a seguinte especificação:
 * “O supermercado vende diferentes tipos de produtos. Cada produto
 * tem um preço e uma quantidade em estoque. Um pedido de um cliente
 * é composto de itens, onde cada item especifica o produto que o
 * cliente deseja e a respectiva quantidade. Esse pedido pode ser pago
 * em dinheiro, cheque ou cartão.”
 */
public class Supermarket {

    public static void main(String[] args) throws Exception {
        Product[] products = {
                new Product("Café", 666, 3.5d),
                new Product("Camisa", 69, 12d),
                new Product("Fone", 42, 250d),
        };

        Item[] items = new Item[products.length];
        items[0] = new Item(products[0], 24);
        items[1] = new Item(products[1], 13);
        items[2] = new Item(products[2], 1);

        Demand demand = new Demand(items);

        System.out.println("Consumindo o pedido formado por:");
        System.out.println("Nome\t |  Preço  | Quantidade |  Total  | Estoque");
        System.out.println("---------------------------------------------------");
        for (Item item : demand.getItems())
            System.out.printf("%s\t | %5.1fR$ | %10d | %5.1fR$ | %d\n",
                    item.getProduct().getName(), item.getProduct().price,
                    item.quantity, item.getPrice(), item.getProduct().stockQuantity);

        System.out.println("---------------------------------------------------");
        System.out.printf("\t\tPreço total: %10.2fR$\n", demand.getTotalPrice());
        try {
            demand.consume();
        } catch (InvalidQuantityException e) {
            System.err.println(e.getMessage());
        }

    }
}
