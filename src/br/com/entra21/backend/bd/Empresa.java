package br.com.entra21.backend.bd;

public class Empresa {

    // =========================== ATRIBUTOS and CONSTRUTORES =========================== //
    private Cliente dono;
    private String razapSocial;
    private String cnpj;

    public Empresa() {
    }
    public Empresa(Cliente dono,String razapSocial, String cnpj) {
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
}
