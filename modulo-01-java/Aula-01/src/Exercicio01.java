import java.util.Scanner;

public class Exercicio01{

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe sua cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Informe seu estado: ");
        String estado = scanner.nextLine();

        System.out.println("Olá, seu nome é " + nome + ", você tem " + idade +
                " anos, é da cidade de " + cidade + ", situada no estado de " + estado + ".");

        scanner.close();
    }
}