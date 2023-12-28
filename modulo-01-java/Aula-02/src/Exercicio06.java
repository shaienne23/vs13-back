import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor = {7, 23, 12, 28, 16, 3, 60, 4, 23, 7};

        System.out.print("Escreva um número: ");
        int numeroInformado = scanner.nextInt();

        int contadorNumeroDigitado = 0;
        for (int elemento : vetor) {
            if (elemento == numeroInformado) {
                contadorNumeroDigitado++;
            }
        }
        if (contadorNumeroDigitado == 1) {
            System.out.println("O número " + numeroInformado + " aparece no vetor 1 vez.");
        } else {
            System.out.println("O número " + numeroInformado + " aparece no vetor " + contadorNumeroDigitado + " vezes.");
        }

        int contadorNumerosMenores = 0;
        for (int elemento : vetor) {
            if (elemento < numeroInformado) {
                contadorNumerosMenores++;
            }
        }
        System.out.println("Existem " + contadorNumerosMenores + " números menores que " + numeroInformado + ".");

        int contadorNumerosMaiores = 0;
        for (int elemento : vetor) {
            if (elemento > numeroInformado) {
                contadorNumerosMaiores++;
            }
        }
        System.out.println("Existem " + contadorNumerosMaiores + " números maiores que " + numeroInformado + ".");
    }
}
