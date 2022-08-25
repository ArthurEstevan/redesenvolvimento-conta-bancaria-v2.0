package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Funcionario extends Pessoa {

    // =========================== Atributos =========================== //
    private String senha;

    // =========================== Construtores =========================== //
    public Funcionario() {
    }

    public Funcionario(String nome) {
        super(nome);
    }

    public Funcionario(String nome, byte idade) {
        super(nome, idade);
    }

    public Funcionario(String nome, byte idade, String cpf, String senha) {
        super(nome, idade, cpf);
        this.senha = senha;
    }

    public Funcionario(String nome, byte idade, String cpf, String rg, String dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, String email, ArrayList<String> reclamacoes, LocalDate dataCadastro, String senha) {
        super(nome, idade, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, email, reclamacoes, dataCadastro);
        this.senha = senha;
    }

    // =========================== Getters and Setters =========================== //
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
