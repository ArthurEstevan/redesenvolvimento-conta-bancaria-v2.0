package br.com.entra21.backend;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Empresa;
import br.com.entra21.backend.bd.Funcionario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public interface Armazenar {
    HashMap<String, Cliente> clientes = new HashMap();
    HashMap<String, Empresa> empresas = new HashMap();
    HashMap<String, Funcionario> funcionarios = new HashMap();

    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataCliente001 = LocalDate.of(1995, 8, 10);
    LocalDate dataCliente002 = LocalDate.of(1960, 1, 23);
    LocalDate dataCliente003 = LocalDate.of(1985, 6, 22);
    LocalDate dataCliente004 = LocalDate.of(1943, 5, 15);
    LocalDate dataCliente005 = LocalDate.of(1947, 1, 8);

    Cliente cliente001 = new Cliente("Sérgio Kaique Augusto Assis", (byte) 27, "001", "48.590.932-7", formatters.format(dataCliente001), "Masculino", "Alana Giovanna", "Ryan Mário Leonardo Assis", "79096-149", "Rua Afluente", "767", "Loteamento Rancho Alegre II", "Campo Grande", "MS", "(67) 99286-1494", "1213026-5", "3048", "sergio_kaique_assis@golinelli.eti.br", new ArrayList<>(List.of("ótimo banco!")), 0);
    Cliente cliente002 = new Cliente("Paulo Matheus Iago da Silva", (byte) 62, "002", "47.902.576-9", formatters.format(dataCliente002), "Masculino", "Luana Sebastiana", "Luís Yago da Silva", "88085-157", "Rua Joaquim Carneiro", "296", "Abraão", "Florianópolis", "SC", "(48) 98653-9187", "0033531-2", "3048", "paulo-dasilva83@bb.com.br", new ArrayList<>(List.of("ótimo banco!")), 0);
    Cliente cliente003 = new Cliente("Louise Amanda Antonella Almada", (byte) 37, "003", "31.175.152-0", formatters.format(dataCliente003), "Feminino", "Emily Benedita Adriana", "Nicolas Bento Almada", "21371-560", "Rua Narciso", "744", "Colégio", "Rio de Janeiro", "RJ", "(21) 99151-7441", "1538648-7", "3048", "louise.amanda.almada@sicredi.com.br", new ArrayList<>(List.of("ótimo banco!")), 0);
    Cliente cliente004 = new Cliente("Stella Alessandra Jesus", (byte) 79, "004", "48.285.899-0", formatters.format(dataCliente004), "Feminino", "Antonella Liz", "Noah Guilherme Heitor Jesus", "58100-466", "2ª Travessa Castelo Branco", "457", "Santa Catarina", "Cabedelo", "PB", "(83) 98498-9657", "93635-9", "3048", "stellaalessandrajesus@hotmail.co.jp", new ArrayList<>(List.of("ótimo banco!")), 0);
    Cliente cliente005 = new Cliente("Lorena Heloise Isis da Luz", (byte) 45, "005", "44.680.748-5", formatters.format(dataCliente005), "Feminino", "Gabrielly Yasmin Sarah", "Kevin Pietro Sebastião da Luz", "71070-506", "Rua 6", "257", "Guará II", "Brasília", "DF", "(61) 99986-7689", "1184124-9", "3048", "lorena_daluz@biconsult.com.br", new ArrayList<>(List.of("ótimo banco!")), 0);
    Cliente cliente006 = new Cliente("The rich", (byte) 100, "006", 1000000);

    static void inicializarBancoDados() {
        inicializarClientes();
        inicializarFuncionarios();
        inicializarEmpresas();
    }

    static void inicializarClientes() {
        clientes.put("001", cliente001);
        clientes.put("002", cliente002);
        clientes.put("003", cliente003);
        clientes.put("004", cliente004);
        clientes.put("005", cliente005);
    }

    static void inicializarEmpresas() {
        empresas.put("001", new Empresa(cliente001,"Sérgio Gráfica ME","96.448.737/0001-40"));
        empresas.put("002", new Empresa(cliente002,"Paulo Filmagens Ltda","59.965.214/0001-45"));
        empresas.put("003", new Empresa(cliente003,"Louise Amanda Mudanças Ltda","49.709.095/0001-06"));
        empresas.put("004", new Empresa(cliente004,"Stella Financeira ME","96.433.348/0001-41"));
        empresas.put("005", new Empresa(cliente005,"Isis Alimentos Ltda","72.566.527/0001-99"));
    }

    static void inicializarFuncionarios() {
        LocalDate cadastro = LocalDate.now();
        funcionarios.put("001", new Funcionario("Admin", (byte) 27, "001", "48.590.932-7", formatters.format(dataCliente001), "Masculino", "Alana Giovanna", "Ryan Mário Leonardo Assis", "79096-149", "Rua Afluente", "767", "Loteamento Rancho Alegre II", "Campo Grande", "MS", "(67) 99286-1494", "1213026-5", new ArrayList<>(List.of("ótimo banco!")), cadastro, "001"));
        funcionarios.put("002", new Funcionario("Dono", (byte) 62, "002", "47.902.576-9", formatters.format(dataCliente002), "Masculino", "Luana Sebastiana", "Luís Yago da Silva", "88085-157", "Rua Joaquim Carneiro", "296", "Abraão", "Florianópolis", "SC", "(48) 98653-9187", "paulo-dasilva83@bb.com.br", new ArrayList<>(List.of("ótimo banco!")), cadastro, "002"));
        funcionarios.put("003", new Funcionario("DevJunior", (byte) 37, "003", "31.175.152-0", formatters.format(dataCliente003), "Feminino", "Emily Benedita Adriana", "Nicolas Bento Almada", "21371-560", "Rua Narciso", "744", "Colégio", "Rio de Janeiro", "RJ", "(21) 99151-7441", "louise.amanda.almada@sicredi.com.br", new ArrayList<>(List.of("ótimo banco!")), cadastro, "003"));
        funcionarios.put("004", new Funcionario("DevPleno", (byte) 79, "004", "48.285.899-0", formatters.format(dataCliente004), "Feminino", "Antonella Liz", "Noah Guilherme Heitor Jesus", "58100-466", "2ª Travessa Castelo Branco", "457", "Santa Catarina", "Cabedelo", "PB", "(83) 98498-9657", "stellaalessandrajesus@hotmail.co.jp", new ArrayList<>(List.of("ótimo banco!")), cadastro, "004"));
        funcionarios.put("005", new Funcionario("DevSenior", (byte) 45, "005", "44.680.748-5", formatters.format(dataCliente005), "Feminino", "Gabrielly Yasmin Sarah", "Kevin Pietro Sebastião da Luz", "71070-506", "Rua 6", "257", "Guará II", "Brasília", "DF", "(61) 99986-7689", "lorena_daluz@biconsult.com.br", new ArrayList<>(List.of("ótimo banco!")), cadastro, "005"));
    }
}
