import java.util.Hashtable;

/*
 * Exercício 8 - Em um sistema de loja, há 3 tipos de usuário:
 * gerente, funcionário e cliente. Todo usuário tem nome e senha.
 * O cliente possui, além do nome e senha, outros dados cadastrais.
 * O funcionário possui métodos relacionados a venda de produtos.
 * O gerente pode fazer tudo que o funcionário pode e também
 * fechamento do caixa. Como é a hierarquia de herança desse
 * sistema no que se refere a controle de usuários?
 */

public class Shop {
    public static void main(String[] args) throws Exception {
        Client client = new Client("Joseph", "1234");
        Functionary functionary = new Functionary("Thadeal", "abc321");
        Manager manager = new Manager("Rosenberg", "53@*aBx_07");

        client.getInfo().put("sells", Integer.valueOf(13));
        client.money = 200d;
        System.out.printf("Client %s, [logged up in %s]:\n",
                client.name, client.getLogDate().toString());

        for (String key : client.getInfo().keySet())
            System.out.printf("\t%s: %s\n", key, client.getInfo().get(key).toString());

        System.out.println();
        System.out.printf("Functionary %s:\n", functionary.name);

        String product = "coffee";
        System.out.printf("Client trying to buy %s [%.2f]\n",
                product, functionary.checkProduct(product));

        if (functionary.sellProduct(product, client))
            System.out.println("Sell made successfully!");

        System.out.println();
        System.out.printf("Manager %s:\n", manager.name);
        manager.closeCashMachine();
    }
}
