import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int itensSupermercado = 10;
        int mercadosConcorrentes = 3;

        double[][] matrizCotacao = new double[itensSupermercado][mercadosConcorrentes];

        int idMercadoMaisBarato = 0;
        double menorPrecoGlobal = Double.MAX_VALUE;

        for (int i = 0; i < itensSupermercado; i++) {
            for (int j = 0; j < mercadosConcorrentes; j++) {
                System.out.println("Informe o preço do item " + (i + 1) + " no mercado " + (j +1) + ": ");
                matrizCotacao[i][j] = scanner.nextDouble();
            }
        }
        for (int j = 0; j < mercadosConcorrentes; j++) {
            double somaPreco = 0;
            for (int i = 0; i < itensSupermercado; i++) {
                somaPreco += matrizCotacao[i][j];
            }
            if (somaPreco < menorPrecoGlobal) {
                menorPrecoGlobal = somaPreco;
                idMercadoMaisBarato = j;
            }
        }
        System.out.println("O Supermercado mais barato é o " + (idMercadoMaisBarato + 1) + " com preço total " + menorPrecoGlobal);
    }
}
