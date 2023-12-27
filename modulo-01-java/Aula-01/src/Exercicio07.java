import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do produto:");
        String codigoProduto = scanner.next();

        System.out.print("Informe a quantidade de produto comprada:");
        int quantidadeProduto = scanner.nextInt();

        scanner.close();

        double precoUnitario = 0;

        switch (codigoProduto.toUpperCase()) {
            case "ABCD":
                precoUnitario = 5.30;
                break;
            case "XYPK":
                precoUnitario = 6.00;
                break;
            case "KLMP":
                precoUnitario = 3.20;
                break;
            case "QRST":
                precoUnitario = 2.50;
                break;
            default:
                System.out.println("O código do produto é invalido.");
                return;
        }

        double precoTotal = precoUnitario * quantidadeProduto;

        System.out.println("O preço total é: R$" + precoTotal);
    }
}