import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite um numero, para ser adivinhado: ");
        int numeroParaAdivinhar = scanner.nextInt();

        System.out.println("Adivinhe o numero secreto: ");
        int numeroSecreto = scanner.nextInt();
        
        if (numeroParaAdivinhar == numeroSecreto){
            System.out.println("Acertou!!");
        } else if (numeroParaAdivinhar > numeroSecreto) {
            System.out.println("Errou. O numero a ser adivinhado é maior do que o numero informado, tente outra vez.");
        } else{
            System.out.println("Errou. O numero a ser adivinhado é menor do que o numero informado, tente outra vez.");
        }
        scanner.close();
    }
}
