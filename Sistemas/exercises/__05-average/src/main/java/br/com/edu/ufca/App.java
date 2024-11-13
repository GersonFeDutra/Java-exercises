package br.com.edu.ufca;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Exercício 5 - Faça um método que calcule a média de um aluno
 * de acordo com o critério definido neste curso. Além disso,
 * faça um outro método que informe o status do aluno de acordo
 * com a tabela a seguir:
 * - Nota acima de 6 “Aprovado”
 * - Nota entre 4 e 6 “Prova de Recuperação”
 * - Nota abaixo de 4 “Reprovado”
 */
public class App {
    private enum Status {
        APPROVED,
        IN_RETAKE_TEST,
        REPROVED,
    }

    private static final int TESTS_N = 4;
    private static final Hashtable<Status, Double> seq = new Hashtable<Status, Double>();
    private static final Hashtable<Status, String> translation = new Hashtable<Status, String>();

    public static void main(String[] args) throws Exception {
        seq.put(Status.APPROVED, 6d);
        seq.put(Status.IN_RETAKE_TEST, 4d);
        seq.put(Status.REPROVED, 0d);
        translation.put(Status.APPROVED, "Aprovado");
        translation.put(Status.IN_RETAKE_TEST, "Em recuperação");
        translation.put(Status.REPROVED, "Reprovado");

        try (Scanner keyboard = new Scanner(System.in)) {
            menu(keyboard);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void menu(Scanner keyboard) {
        double[] grades = new double[TESTS_N];
        final String TRY_AGAIN = "Tente novamente: ";

        System.out.println("---------- Média ----------");

        for (int i = 0; i < TESTS_N; ++i) {
            System.out.printf("Insira a %d° nota: ", i + 1);

            for (;;) // loop
                {try {
                    grades[i] = keyboard.nextInt();
                    keyboard.nextLine();

                    if (grades[i] >= 0d && grades[i] <= 10d)
                        break;

                    System.out.println("Erro! Valor deve estar entre 0 e 10");
                    System.out.printf(TRY_AGAIN);
                } catch (InputMismatchException e) {
                    keyboard.nextLine();
                    System.out.println("Erro! Valor inválido!");
                    System.out.printf(TRY_AGAIN);
                    continue;
                }}
        }

        double average = getAverage(grades);
        System.out.printf("Sua média é: %.1f.\n", average);
        System.out.printf("Seu estado é: %s!\n",
                translation.get(getStatus(average)));
    }

    public static double getAverage(double[] grades) {
        double average = 0d;

        for (double grade : grades)
            average += grade;

        return average /= grades.length;
    }

    public static Status getStatus(double average) {

        for (Status status : Status.values())
            if (average >= seq.get(status))
                return status;

        return Status.REPROVED;
    }
}
