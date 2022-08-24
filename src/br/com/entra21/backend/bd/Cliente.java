package br.com.entra21.backend.bd;


import java.util.ArrayList;

public class Cliente extends Pessoa {

    // =========================== CONSTRUTORES =========================== //

    private double saldo;

    public Cliente() {
    }

    public Cliente(String nome) {
        super(nome);
    }

    public Cliente(String nome, byte idade) {
        super(nome, idade);
    }

    public Cliente(String nome, byte idade, String cpf) {
        super(nome, idade, cpf);
    }

    public Cliente(String nome, byte idade, String cpf, double saldo) {
        super(nome, idade, cpf);
        this.saldo = saldo;
    }

    public Cliente(String nome, byte idade, String cpf, String rg, String dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, String contaCorente, String agencia, String email, ArrayList<String> reclamacoes, double saldo) {
        super(nome, idade, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, contaCorente, agencia, email, reclamacoes);
        this.saldo = saldo;
    }
    // =========================== CONSTRUTORES =========================== //

    // =========================== GETTERS AND SETTERS =========================== //
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
