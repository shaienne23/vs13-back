import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Informe o número total de eleitores: ");
    int totalEleitores = scanner.nextInt();

    System.out.print("Informe o número de votos brancos: ");
    int votosBrancos = scanner.nextInt();

    System.out.print("Informe o número de votos nulos: ");
    int votosNulos = scanner.nextInt();

    System.out.print("Informe o número de votos válidos: ");
    int votosValidos = scanner.nextInt();

    scanner.close();

    float votosBrancosPercentual = (float) votosBrancos / totalEleitores * 100;
    float votosNulosPercentual = (float) votosNulos / totalEleitores * 100;
    float votosValidosPercentual = (float) votosValidos / totalEleitores * 100;


    System.out.println("Resultados:");
    System.out.println("Percentual de votos brancos,em relação ao total de eleitores: " + votosBrancosPercentual + "%");
    System.out.println("Percentual de votos nulos,em relação ao total de eleitores: " + votosNulosPercentual  + "%");
    System.out.println("Percentual de votos válidos,em relação ao total de eleitores: " + votosValidosPercentual + "%");
    }
}
