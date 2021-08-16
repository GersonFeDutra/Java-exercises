import java.util.Arrays;
import java.util.Scanner;


public class Test {

	/*
	 * Testa o projeto de Programação Orientada à Objetos implementado com base na seguinte
	 * especificação:
	 * <https://docs.google.com/document/d/1nnI7JwJLMDSYZHwK4ms7AIq1Mb7A7Dxl5zUMECqPvXE>.
	 * - Argumentos opcionais: `-t` execução em modo de teste.
	 */
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			final int CLUBS = 6;
			Championship championship = new Championship(CLUBS);

			if (Arrays.asList(args).contains("-t")) {
				// Execução em modo de teste: com valores pré gerados.
				String[] foo = { "Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Consectetur" };
				for (int i = 0; i < CLUBS; ++i)
					championship.clubs[i] = new Club(foo[i]);
			}
			else {
				// Execução normal: valores inseridos pelo usuário.
				System.out.println("Insira o nome de 6 clubes de futebol: ");

				for (int i = 0; i < CLUBS; ++i)
					championship.clubs[i] = new Club(scan.next());
			}

			System.out.printf("\nO clube campeão foi %s!\n\n",
					championship.playChampionship().name);
			System.out.println(championship.toString());
			System.out.println();
		}
	}
}


/* Hello
              _-o#&&*''''?d:>b\_
          _o/"`''  '',, dMF9MMMMMHo_
       .o&#'        `"MbHMMMMMMMMMMMHo.
     .o"" '         vodM*$&&HMMMMMMMMMM?.
    ,'              $M&ood,~'`(&##MMMMMMH\
   /               ,MMMMMMM#b?#bobMMMMHMMML
  &              ?MMMMMMMMMMMMMMMMM7MMM$R*Hk
 ?$.            :MMMMMMMMMMMMMMMMMMM/HMMM|`*L
|               |MMMMMMMMMMMMMMMMMMMMbMH'   T,
$H#:            `*MMMMMMMMMMMMMMMMMMMMb#}'  `?
]MMH#             ""*""""*#MMMMMMMMMMMMM'    -
MMMMMb_                   |MMMMMMMMMMMP'     :
HMMMMMMMHo                 `MMMMMMMMMT       .
?MMMMMMMMP                  9MMMMMMMM}       -
-?MMMMMMM                  |MMMMMMMMM?,d-    '
 :|MMMMMM-                 `MMMMMMMT .M|.   :
  .9MMM[                    &MMMMM*' `'    .
   :9MMk                    `MMM#"        -
     &M}                     `          .-
      `&.                             .
        `~,   .                     ./
            . _                  .-
              '`--._,dd###pp=""' ! */
