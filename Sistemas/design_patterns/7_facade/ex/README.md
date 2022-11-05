## Facade

Utilizando o padrão de projeto Facade. Desenvolva um programa para uma loja online de celulares que
vende aparelhos Xiaomi, iPhone e Samsung para lojistas. Não é permitida a venda no varejo. Os
aparelhos mais vendidos na loja são: Apple iPhone 13, Samsung Galaxy A52s e Xiaomi Redmi Note 11
LTE. Para cada aparelho, precisamos informar o modelo, o preço e a quantidade em estoque.

#### Código parcial

```Java
public class FacadePatternClient {
    private static int option;

    public static void main(String args[]) {
        do {
            System.out.print("========= Mobile Shop ============ \n");
            System.out.print("1. APPLE.              \n");
            System.out.print("2. SAMSUNG.              \n");
            System.out.print("3. XIAOMI.                 \n");
            System.out.print("4. Exit.                   \n");
            System.out.print("Enter your choice: ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            option = Integer.parseInt(br.readLine());
            Lojista lojista = new Lojista();

            switch (option) {
                case 1: lojista.appleVenda(); break;
                case 2: lojista.samsungVenda(); break;
                case 3: lojista.xiaomiVenda(); break;
                default: System.out.println("Opção inválida!"); return;
            }
        } while (choice != 4);
    }
}
```

#### Diagrama

![Aula 09 - Facade](./Aula%2009%20-%20Facade.jpg)
