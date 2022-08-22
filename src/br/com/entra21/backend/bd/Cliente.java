package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;
public class Cliente extends Pessoa {

    // =========================== CONSTRUTORES =========================== //
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
    public Cliente(String nome, byte idade, String cpf, String rg, LocalDate dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, String contaCorente, String agencia, String email, ArrayList<String> reclamacoes) {
        super(nome, idade, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, contaCorente, agencia, email, reclamacoes);
    }
    // =========================== CONSTRUTORES =========================== //
}
