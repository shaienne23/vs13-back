import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a hora de início (hora e minutos separados por espaço):");
        int horaInicio = scanner.nextInt();
        int minutoInicio = scanner.nextInt();

        System.out.println("Digite a hora de término (hora e minutos separados por espaço):");
        int horaTermino = scanner.nextInt();
        int minutoTermino = scanner.nextInt();

        scanner.close();

        int duracaoHoras;
        int duracaoMinutos;

        int minutosInicio = horaInicio * 60 + minutoInicio;
        int minutosTermino = horaTermino * 60 + minutoTermino;

        int diferencaMinutos = minutosTermino - minutosInicio;

        if (diferencaMinutos < 0) {
            diferencaMinutos += 24 * 60;
        }

        duracaoHoras = diferencaMinutos / 60;
        duracaoMinutos = diferencaMinutos % 60;

        System.out.println("A duração do jogo é: " + duracaoHoras + " horas e " + duracaoMinutos + " minutos.");
    }
}

