import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavra para tradução:");
        String palavra = scanner.nextLine().toLowerCase();

        String traducao = "";

        switch (palavra) {
            case "cachorro":
                traducao = "Dog";
                break;
            case "tempo":
                traducao = "Time";
                break;
            case "amor":
                traducao = "Love";
                break;
            case "cidade":
                traducao = "City";
                break;
            case "feliz":
                traducao = "Happy";
                break;
            case "triste":
                traducao = "Sad";
                break;
            case "deveria":
                traducao = "Should";
                break;
            case "poderia":
                traducao = "Could";
                break;
            case "dog":
                traducao = "Cachorro";
                break;
            case "time":
                traducao = "Tempo";
                break;
            case "love":
                traducao = "Amor";
                break;
            case "city":
                traducao = "Cidade";
                break;
            case "happy":
                traducao = "Feliz";
                break;
            case "sad":
                traducao = "Triste";
                break;
            case "should":
                traducao = "Deveria";
                break;
            case "could":
                traducao = "Poderia";
                break;
            default:
                System.out.println("Essa palavra não é válida.");
                break;
        }
        System.out.println("A tradução da palavra é: " + traducao);
        scanner.close();
    }
}