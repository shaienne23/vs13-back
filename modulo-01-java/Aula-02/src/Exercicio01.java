import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.println("Digite o valor do produto: ");
        double valorProduto = scanner.nextDouble();

        System.out.println("Produto: " + nomeProduto);
        System.out.println("-----------------------");

        for (double i = 1; i <= 10; i++) {
            double desconto = i * 5.0;
            double calculoDesconto = valorProduto * (desconto / 100);
            double precoComDesconto = valorProduto - calculoDesconto;

            System.out.println(i + " x R$ " + String.format("%.2f", precoComDesconto) +
                    " = R$ " + String.format("%.2f", i * precoComDesconto));
            }

        scanner.close();
    }
}