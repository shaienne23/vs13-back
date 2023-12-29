public class Exercicio04 {
    public static void main(String[] args) {
        int variavelA = 50;
        int variavelB = 20;

        int variavelAuxiliar = variavelA;
        variavelA = variavelB;
        variavelB = variavelAuxiliar;

        System.out.println("Valor da variável A: " + variavelA);
        System.out.println("Valor da variável B: " + variavelB);
    }
}