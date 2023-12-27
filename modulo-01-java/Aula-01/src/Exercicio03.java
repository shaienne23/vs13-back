import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a palavra para tradução e digite a opção escolhida:");
        System.out.println("a. Cachorro");
        System.out.println("b. Tempo");
        System.out.println("c. Amor");
        System.out.println("d. Cidade");
        System.out.println("e. Feliz");
        System.out.println("f. Triste");
        System.out.println("g. Deveria");
        System.out.println("h. Poderia");
        System.out.println("i. Dog");
        System.out.println("j. Time");
        System.out.println("k. Love");
        System.out.println("l. City");
        System.out.println("m. Happy");
        System.out.println("n. Sad");
        System.out.println("o. Should");
        System.out.println("p. Could");

        char escolhaPalavra = scanner.next().charAt(0);
        scanner.nextLine();

        if (escolhaPalavra == 'a') {
            System.out.println("A tradução da palavra é Dog.");
        } else if (escolhaPalavra == 'b') {
            System.out.println("A tradução da palavra é Time.");
        } else if (escolhaPalavra == 'c') {
            System.out.println("A tradução da palavra é Love.");
        } else if (escolhaPalavra == 'd') {
            System.out.println("A tradução da palavra é City.");
        } else if (escolhaPalavra == 'e') {
            System.out.println("A tradução da palavra é Happy.");
        } else if (escolhaPalavra == 'f') {
            System.out.println("A tradução da palavra é Sad.");
        } else if (escolhaPalavra == 'g') {
            System.out.println("A tradução da palavra é Should.");
        } else if (escolhaPalavra == 'h') {
            System.out.println("A tradução da palavra é Could.");
        } else if (escolhaPalavra == 'i') {
            System.out.println("A tradução da palavra é Cachorro.");
        } else if (escolhaPalavra == 'j') {
            System.out.println("A tradução da palavra é Tempo.");
        } else if (escolhaPalavra == 'k') {
            System.out.println("A tradução da palavra é Amor.");
        } else if (escolhaPalavra == 'l') {
            System.out.println("A tradução da palavra é Cidade.");
        } else if (escolhaPalavra == 'm') {
            System.out.println("A tradução da palavra é Feliz.");
        } else if (escolhaPalavra == 'n') {
            System.out.println("A tradução da palavra é Triste.");
        } else if (escolhaPalavra == 'o') {
            System.out.println("A tradução da palavra é Should.");
        } else if (escolhaPalavra == 'p') {
            System.out.println("A tradução da palavra é Could.");
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
