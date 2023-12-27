import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de identificação do aluno: ");
        int numeroIdentificacao = scanner.nextInt();

        System.out.print("Informe a primeira nota: ");
        double notaUm = scanner.nextDouble();

        System.out.print("Informe a segunda nota: ");
        double notaDois = scanner.nextDouble();

        System.out.print("Informe a terceira nota: ");
        double notaTres = scanner.nextDouble();

        System.out.print("Informe a média dos exercícios: ");
        double mediaExercicios = scanner.nextDouble();

        scanner.close();

        double mediaAproveitamento = (notaUm + notaDois * 2 + notaTres * 3 + mediaExercicios) / 7;

        char conceito;
        if (mediaAproveitamento >= 9.0) {
            conceito = 'A';
        } else if (mediaAproveitamento >= 7.5) {
            conceito = 'B';
        } else if (mediaAproveitamento >= 6.0) {
            conceito = 'C';
        } else if (mediaAproveitamento >= 4.0) {
            conceito = 'D';
        } else {
            conceito = 'E';
        }

        System.out.println("Número de Identificação: " + numeroIdentificacao);
        System.out.println("Notas: A nota da primeira verificação:" + notaUm +
                ", A nota da segunda verificação:" + notaDois + ", A nota da terceira verificação:" + notaTres);
        System.out.println("A Média dos Exercícios: " + mediaExercicios);
        System.out.println("A Média de Aproveitamento: " + mediaAproveitamento);
        System.out.println("Conceito: " + conceito);

        if (conceito == 'A' || conceito == 'B' || conceito == 'C') {
            System.out.println("APROVADO");
        } else {
            System.out.println("REPROVADO");
        }
    }
}
