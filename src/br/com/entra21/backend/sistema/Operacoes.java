package br.com.entra21.backend.sistema;

import java.util.ArrayList;
import java.util.Arrays;

public interface Operacoes {

    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList("Dados bancários", "Depósito", "Sacar", "Transferência", "Investimento", "Saldo"));

    public void dadosBancario();

    public void deposito(double pValor);

    public void sacar(double pValor);

    public void transferencia(double pValor);

    public void investimento();

    public void saldo();

    public double capturandoValor();
}
