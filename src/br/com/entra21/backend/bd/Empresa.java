package br.com.entra21.backend.bd;

public class Empresa {

    // =========================== ATRIBUTOS and CONSTRUTORES =========================== //
    private Cliente dono;
    private String razapSocial;
    private String cnpj;

    public Empresa() {
    }
    public Empresa(Cliente dono, String razapSocial, String cnpj) {
        this.cnpj = cnpj;
        this.razapSocial = razapSocial;
        this.dono = dono;
    }
    // =========================== ATRIBUTOS and CONSTRUTORES =========================== //

    // =========================== GETTER and SETTER =========================== //
    public String getCnpj() {
        return cnpj;
    }

    public Cliente getDono() {
        return dono;
    }

    public String getRazapSocial() {
        return razapSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setRazapSocial(String razapSocial) {
        this.razapSocial = razapSocial;
    }
    // =========================== GETTER and SETTER =========================== //

    @Override
    public String toString() {
        return
                '\n' + "Dados pessoais" + '\n' +

                        '\n' + "| " + "Nome: " + dono.getNome() + "   " + "Sexo: " + dono.getSexo() + "   " + "Data de nascimento: " + dono.getDataNascimento() + "   " + "Idade: " + dono.getIdade() + '\n' +

                        "| " + "CEP: " + dono.getCep() + "   " + "CPF: " + dono.getCpf() + "   " + "RG: " + dono.getRg() + '\n' +

                        "| " + "Mãe: " + dono.getMae() + "   " + "Pai: " + dono.getPai() + '\n' +

                        "| " + "Celular: " + dono.getCelular() + "   " + "Email: " + dono.getEmail() + '\n' +

                        "| " + "Data de cadastro=" + dono.getDataCadastro() + "Reclamacoes=" + dono.getReclamacoes() + '\n' +

                        '\n' + "Local de nascimento" + '\n' +

                        '\n' + "| " + "Estado: " + dono.getEstado() + "   " + "Cidade: " + dono.getCidade() + '\n' +

                        "| " + "Endereço: " + dono.getEndereco() + "   " + "Número: " + dono.getNumero() + "   " + "Bairro: " + dono.getBairro() +

                        "| " + "Estado: " + dono.getEstado() + "   " + "Cidade: " + dono.getCidade() + '\n' +

                        '\n' + "Dados da empresa" + '\n' +

                        '\n' + "| " + "Razão social: " + razapSocial + "   " + "CNPJ: " + cnpj;
    }
}
