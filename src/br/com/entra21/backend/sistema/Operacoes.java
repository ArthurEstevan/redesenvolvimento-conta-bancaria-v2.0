package br.com.entra21.backend.sistema;

import java.util.ArrayList;
import java.util.Arrays;

public interface Operacoes {

    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList("Dados bancários", "Depósito", "Sacar", "Transferência", "Investimento", "Saldo"));

    void dadosBancario();

    void deposito(double pValor);

    void sacar(double pValor);

    void transferencia(double pValor);

    void investimento();

    void saldo();

    double capturandoValor();
}
