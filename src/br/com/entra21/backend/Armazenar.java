package br.com.entra21.backend;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Empresa;
import br.com.entra21.backend.bd.Funcionario;

import java.util.HashMap;
public interface Armazenar {
    public HashMap<String, Cliente> clientes = new HashMap();
    public HashMap<String, Empresa> empresas = new HashMap();
    public HashMap<String, Funcionario> funcionarios = new HashMap();

    // variável de teste para gerar empresa após
    Cliente cliente = new Cliente("Ricardo Yago Marcelo Moraes", (byte) 74, "001");
    public static void inicializarBancoDados() {
        inicializarClientes();
        inicializarFuncionarios();
        inicializarEmpresas();
    }
    public static void inicializarClientes() {
        clientes.put("001", cliente);
    }
    public static void inicializarEmpresas() {
        Empresa empresa = new Empresa( cliente,"Ricardo Gráfica ME","96.448.737/0001-40");
        empresas.put("001", empresa);
    }
    public static void inicializarFuncionarios() {
        Funcionario funcionario = new Funcionario("Admin", (byte) 33, "001");
        funcionarios.put("001", funcionario);
    }
}
