import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a base do retângulo:");
        float base = scanner.nextFloat();

        System.out.print("Informe a altura do retângulo:");
        float altura = scanner.nextFloat();

        scanner.close();

        float areaTotal = base * altura;
        System.out.println("A área do retângulo é: " + areaTotal);

    }
}
