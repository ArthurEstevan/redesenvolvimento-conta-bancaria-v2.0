package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {

    // =========================== ATRIBUTOS =========================== //
    private String nome;
    private byte idade;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String sexo;
    private String mae;
    private String pai;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;
    private String contaCorente;
    private String agencia;
    private String email;
    private ArrayList<String> reclamacoes;
    private LocalDate dataCadastro;

    // =========================== ATRIBUTOS =========================== //

    // =========================== CONSTRUTORES =========================== //
    public Pessoa() {
        super();
    }

    public Pessoa(String nome) {
        super();
        this.nome = nome;
        this.dataCadastro = LocalDate.now();
    }

    public Pessoa(String nome, byte idade) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.dataCadastro = LocalDate.now();
    }

    public Pessoa(String nome, byte idade, String cpf) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.dataCadastro = LocalDate.now();
    }

    // =========================== cliente =========================== //
    public Pessoa(String nome, byte idade, String cpf, String rg, LocalDate dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, String contaCorente, String agencia, String email, ArrayList<String> reclamacoes) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.celular = celular;
        this.contaCorente = contaCorente;
        this.agencia = agencia;
        this.email = email;
        this.reclamacoes = reclamacoes;
        this.dataCadastro = LocalDate.now();
    }
    // =========================== cliente =========================== //

    // =========================== funcionario =========================== //
    public Pessoa(String nome, byte idade, String cpf, String rg, LocalDate dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, String email, ArrayList<String> reclamacoes, LocalDate dataCadastro) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.celular = celular;
        this.email = email;
        this.reclamacoes = reclamacoes;
        this.dataCadastro = dataCadastro;
    }
    // =========================== funcionario =========================== //

    // =========================== CONSTRUTORES =========================== //

    // =========================== GETTER =========================== //
    public String getNome() {
        return nome;
    }

    public byte getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getMae() {
        return mae;
    }

    public String getPai() {
        return pai;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCelular() {
        return celular;
    }

    public String getContaCorente() {
        return contaCorente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getReclamacoes() {
        return reclamacoes;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    // =========================== GETTER =========================== //

    // =========================== SETTER =========================== //
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setContaCorente(String contaCorente) {
        this.contaCorente = contaCorente;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReclamacoes(ArrayList<String> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // =========================== SETTER =========================== //

    // =========================== toString =========================== //
    @Override
    public String toString() {
        return
                '\n' + "Dados pessoais" + '\n' +

                        '\n' + "| " + "Nome: " + nome + "   " + "Sexo: " + sexo + "   " + "Data de nascimento: " + dataNascimento + "   " + "Idade: " + idade + '\n' +

                        "| " + "CEP: " + cep + "   " + "CPF: " + cpf + "   " + "RG: " + rg + '\n' +

                        "| " + "Mãe: " + mae + "   " + "Pai: " + pai + '\n' +

                        "| " + "Celular: " + celular + "   " + "Email: " + email + '\n' +

                        "| " + "Conta-Corente: " + contaCorente + "   " + "Agência: " + agencia + "   " + "Data de cadastro: " + dataCadastro + '\n' +

                        "| " + "Reclamacoes=" + reclamacoes + '\n' +

                        '\n' + "Local de nascimento" + '\n' +

                        '\n' + "| " + "Estado: " + estado + "   " + "Cidade: " + cidade + '\n' +

                        "| " + "Endereço: " + endereco + "   " + "Número: " + numero + "   " + "Bairro: " + bairro;
    }
    // =========================== toString =========================== //
}
