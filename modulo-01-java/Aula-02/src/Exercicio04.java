import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantDeAlunos = 5;
        int numerocolunas = 4;

        int[][] matrizDeNotas = new int[quantDeAlunos][numerocolunas];

        int maiorNota = 0;
        int matriculaMaiorNota = 0;
        int somaFinalDasNotas = 0;

        for (int i = 0; i < quantDeAlunos; i++) {
            System.out.println("Escreva a matrícula do aluno " + (i + 1) + ": ");
            matrizDeNotas[i][0] = scanner.nextInt();

            System.out.println("Escreva a média das provas do aluno " + (i + 1) + ": ");
            matrizDeNotas[i][1] = scanner.nextInt();

            System.out.println("Escreva a média dos trabalhos do aluno " + (i + 1) + ": ");

            matrizDeNotas[i][2] = scanner.nextInt();
            matrizDeNotas[i][3] = (int) ((matrizDeNotas[i][1] * 0.6) + (matrizDeNotas[i][2] * 0.4));

            if (matrizDeNotas[i][3] > maiorNota) {
                maiorNota = matrizDeNotas[i][3];
                matriculaMaiorNota = matrizDeNotas[i][0];
            }

            somaFinalDasNotas += matrizDeNotas[i][3];
        }

        System.out.println("A matrícula com a maior nota final é: " + matriculaMaiorNota);

        double mediaNotasFinais = (double) somaFinalDasNotas / quantDeAlunos;
        System.out.println("Média das notas finais: " + mediaNotasFinais);

        scanner.close();
    }
}
