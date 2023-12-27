import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o salário:");
        double salario = scanner.nextDouble();

        System.out.println("Informe o cargo:");
        scanner.nextLine();
        String cargo = scanner.nextLine();

        scanner.close();

        double percentualReajuste = 0;

        switch (cargo.toLowerCase()) {
            case "gerente":
                percentualReajuste = 0.10;
                break;
            case "engenheiro":
                percentualReajuste = 0.20;
                break;
            case "técnico":
                percentualReajuste = 0.30;
                break;
            default:
                percentualReajuste = 0.40;
                break;
        }
        double valorAumento = salario * percentualReajuste;
        double novoSalario = salario + valorAumento;

        System.out.println("Salário antigo: R$" + salario);
        System.out.println("Novo salário: R$" + novoSalario);
        System.out.println("Aumento: R$" + valorAumento);
    }
}