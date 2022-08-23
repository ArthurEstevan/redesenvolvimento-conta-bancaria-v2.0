package br.com.entra21.backend;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Empresa;
import br.com.entra21.backend.bd.Funcionario;
import java.util.HashMap;

public interface Armazenar {
    HashMap<String, Cliente> clientes = new HashMap();
    HashMap<String, Empresa> empresas = new HashMap();
    HashMap<String, Funcionario> funcionarios = new HashMap();

    // variável de teste para gerar empresa após
    Cliente cliente = new Cliente("Ricardo Yago Marcelo Moraes", (byte) 74, "001");
    static void inicializarBancoDados() {
        inicializarClientes();
        inicializarFuncionarios();
        inicializarEmpresas();
    }
    static void inicializarClientes() {
        clientes.put("001", cliente);
        clientes.put("002", new Cliente("Emilly Rafaela Lopes", (byte) 51, "002"));
        clientes.put("003", new Cliente("Cláudia Lorena Maitê de Paula", (byte) 61, "003"));
        clientes.put("004", new Cliente("Diogo André Gonçalves", (byte) 36, "004"));
    }
    static void inicializarEmpresas() {
        Empresa empresa = new Empresa(cliente,"Ricardo Gráfica ME","96.448.737/0001-40");
        empresas.put(cliente.getCpf(), empresa);
    }
    static void inicializarFuncionarios() {
        Funcionario funcionario = new Funcionario("Admin", (byte) 33, "001", "001");
        funcionarios.put("001", funcionario);
    }
}
