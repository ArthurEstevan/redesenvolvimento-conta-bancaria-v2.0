package br.com.entra21.backend.menu;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.exceptions.FuncionarioExistenteException;
import br.com.entra21.backend.exceptions.SenhaIncorretaException;
import br.com.entra21.backend.icrud.ICrudFuncionario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chamadas {
    static Scanner input = new Scanner(System.in);
    static Funcionario funcionarioLogado = null;

    // =========================== Entrar =========================== //
    public static void entrar(byte tentativa) {
        if (tentativa == 0) {
            System.out.println("Desculpe a inform��o est� incorreta.");
        } else {
            LocalDate amostra = LocalDate.now();
            System.out.println("\nBem vindo - " + amostra + " - 3/" + tentativa);
            System.out.println("==========================================");
        }

        try {
            System.out.print("Informe o cpf do funcion�rio: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Ol� Sr. " + funcionario.getNome() + ".");
            System.out.print("Informe a senha para liberar acesso: ");

            if (!funcionario.getSenha().equals(input.next())) {
                throw new SenhaIncorretaException();

            } else {
                verificarSenha(funcionario);
            }

        } catch (NullPointerException e) {
            System.out.println("Nenhum funcion�rio cadastrado com este cpf");
            entrar(--tentativa);
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getMessage());
            entrar(--tentativa);
        }
    }

    private static void verificarSenha(Funcionario funcionario) {
        if (funcionario.getSenha().equals(funcionario.getCpf()) || funcionario.getSenha().equals(funcionario.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
            atualizarSenha(funcionario);
        } else {
            definirFuncionarioLogado(funcionario);

            new CadastroMenu(new ArrayList<>(Arrays.asList("Icrud Cliente", "Icrud Funcion�rio", "Icrud Empresa")), "de Cadastros").executarMenu();
        }
    }

    private static void definirFuncionarioLogado(Funcionario funcionario) {
        if (funcionario != null) {
            System.out.println("~Tenha um �timo dia de trabalho Sr. " + funcionario.getNome() + "~");
        } else {
            assert false;
            System.out.println("~Espero que tenha tido um �timo dia de trabalaho Sr. " + funcionario.getNome() + "~");
        }
        funcionarioLogado = funcionario;
    }

    private static void atualizarSenha(Funcionario funcionario) {
        System.out.print("Senhas iguais a cpf ou data de cadastro podem ser vulner�veis � melhor alterar: ");
        funcionario.setSenha(input.next());
        verificarSenha(funcionario);
    }

    // =========================== Cadastrar =========================== //
    public static void cadastrar(byte tentativa) {

        String cpf = null;

        if (tentativa == 0) {
            System.out.println("Desculpe a inform��o est� incorreta.");
            return;
        } else {
            LocalDate amostra = LocalDate.now();
            System.out.println("\nBem vindo - " + amostra + " - 3/" + tentativa);
            System.out.println("==========================================");
        }
        try {
            for (int count = 1; count < 2; count++) {
                cpf = "00" + (count + Armazenar.funcionarios.size());
            }

            Funcionario funcionario = Armazenar.funcionarios.get(cpf);

            if (funcionario != null) {
                throw new FuncionarioExistenteException();
            } else {
                funcionario = new ICrudFuncionario().capturarValores();
                System.out.println("CPF: " + funcionario.getCpf());
                funcionario.setCpf(cpf);
                funcionario.setSenha(cpf);
                Armazenar.funcionarios.put(cpf, funcionario);
                System.out.println();
                System.out.println("-funcionario cadastrado-");
                System.out.println("IMPORTANTE: No primeiro acesso a senha e igual ao CPF e sera solicitado a mudanca:");
                System.out.println("~~~~~~~~~~~~ Bem Vindo ao Time Sr. " + funcionario.getNome() + " ~~~~~~~~~~~~");
            }
        } catch (FuncionarioExistenteException e) {
            System.out.println(e.getMessage());
            cadastrar(--tentativa);
        }
    }

    // =========================== Sobre =========================== //
    public static void sobre() {
        System.out.println("\n\t\t\t\t\t\t\t\t============== Sobre o Projeto ==============\n");

        System.out.println("""
                Sistema Banc�rio, onde temos as funcionalidades de um banco como por exemplo: cadastro de conta, login de conta,
                a��es banc�rias do dia a dia tamb�m implementa��o de uma regra de neg�cio, nesse caso utilizei investimento\s
                para resaltar essa parte.
                """);

        System.out.println("- Organiza��o: TimeVerde");
        System.out.println("- Autor: Arthur Estevan | Rafael Macedo | Thabata Santos | Erick Gabriel");
        System.out.println("- Vers�o: GreenBank v2.0");
        System.out.println("- Linguagem: Portugu�s");

        System.out.println("============================================");
    }

    // =========================== Recupera��o de senha =========================== //
    public static void recuperarSenha(byte tentativa) {

        if (tentativa == 0) {
            System.out.println("Desculpe a inform��o est� incorreta.");
            return;
        } else {
            LocalDate amostra = LocalDate.now();
            System.out.println("\nBem vindo - " + amostra + " - 3/" + tentativa);
            System.out.println("==========================================");
        }
        try {
            System.out.print("Informe o CPF do funcionario: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Funcionario encontrado: " + funcionario.getNome());
            funcionario.setSenha(funcionario.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            Armazenar.funcionarios.put(funcionario.getCpf(), funcionario);

            System.out.println("A senha foi atualizada com a data de admissao no formato dd/MM/YYYY:");
            System.out.println("Funcion�rio atualizado, por favor realize o login:");

            System.out.println("==============================================");

        } catch (NullPointerException e) {

            System.out.println("Nenhum funcion�rio encontrado com esse CPF.");
            recuperarSenha(--tentativa);
        }
    }
}
