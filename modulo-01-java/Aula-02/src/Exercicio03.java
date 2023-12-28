import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidadeJogadores = 0;
        double alturaMaiorJogador = 0;
        int jogadorMaisVelho = 0;
        double jogadorMaisPesado = 0;
        double somaAlturas = 0;

        while (true) {
            System.out.println("Digite o nome do jogador (ou digite 'SAIR' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }

            System.out.println("Digite a altura do jogador (metros e centimetros): ");
            double altura = scanner.nextDouble();

            System.out.println("Digite a idade do jogador: ");
            int idade = scanner.nextInt();

            System.out.println("Digite o peso do jogador (em kg): ");
            double peso = scanner.nextDouble();

            scanner.nextLine();

            quantidadeJogadores++;
            somaAlturas += altura;

            if (altura > alturaMaiorJogador) {
                alturaMaiorJogador = altura;
            }

            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
            }

            if (peso > jogadorMaisPesado) {
                jogadorMaisPesado = peso;
            }
        }

        double mediaAlturas = somaAlturas / quantidadeJogadores;

        System.out.println("\nResumo das informações:");
        System.out.println("Quantidade de jogadores cadastrados: " + quantidadeJogadores);
        System.out.println("Altura do maior jogador: " + alturaMaiorJogador);
        System.out.println("Jogador mais velho: " + jogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + jogadorMaisPesado + " kg");
        System.out.println("Média das alturas dos jogadores: " + mediaAlturas + " metros");

        scanner.close();
    }
}
