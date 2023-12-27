import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a opção do seu estado:");
        System.out.println("1. Espirito Santo.");
        System.out.println("2. Minas Gerais.");
        System.out.println("3. São Paulo.");

        int escolhaEstado = scanner.nextInt();
        scanner.nextLine();

        if (escolhaEstado == 1) {
            System.out.println("Seu estado é Espírito Santo. Agora digite a opção de sua cidade:");
            System.out.println("a. Serra.");
            System.out.println("b. Vitória.");

            char escolhaCidade = scanner.nextLine().charAt(0);

            if (escolhaCidade == 'a') {
                System.out.println("Você escolheu Serra.");
            } else if (escolhaCidade == 'b') {
                System.out.println("Você escolheu Vitória.");
            } else {
                System.out.println("Opção inválida.");
            }

        } else if (escolhaEstado == 2) {
            System.out.println("Seu estado é Minas Gerais. Agora digite a opção de sua cidade:");
            System.out.println("a. Governador Valadares.");
            System.out.println("b. Belo Horizonte.");

            char escolhaCidade = scanner.nextLine().charAt(0);

            if (escolhaCidade == 'a') {
                System.out.println("Você escolheu Governador Valadares.");
            } else if (escolhaCidade == 'b') {
                System.out.println("Você escolheu Belo Horizonte.");
            } else {
                System.out.println("Opção inválida.");
            }

        } else if (escolhaEstado == 3) {
            System.out.println("Seu estado é São Paulo. Agora digite a opção de sua cidade:");
            System.out.println("a. Araras.");
            System.out.println("b. Campinas.");

            char escolhaCidade = scanner.nextLine().charAt(0);

            if (escolhaCidade == 'a') {
                System.out.println("Você escolheu Araras.");
            } else if (escolhaCidade == 'b') {
                System.out.println("Você escolheu Campinas.");
            } else {
                System.out.println("Opção inválida.");
            }

        } else {
            System.out.println("O Estado selecionado é inválido.");
        }

        scanner.close();
    }

}