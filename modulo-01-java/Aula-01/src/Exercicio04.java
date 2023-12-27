public class Exercicio04 {
    public static void main(String[] args) {
        int variavelA = 10;
        int variavelB = 20;

        variavelA = variavelA + variavelB;
        variavelB = variavelA - variavelB;
        variavelA = variavelA - variavelB;

        System.out.println("Valor da variavel A: " + variavelA);
        System.out.println("Valor da variavel B: " + variavelB);
    }
}