package Interfaces;

import Classes.Conta;

public interface MovimentacaoInterface {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(Conta destino, double valor);
}

