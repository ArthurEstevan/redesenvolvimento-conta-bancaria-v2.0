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
            System.out.println("Desculpe a informção está incorreta.");
        } else {
            LocalDate amostra = LocalDate.now();
            System.out.println("\nBem vindo - " + amostra + " - 3/" + tentativa);
            System.out.println("==========================================");
        }

        try {
            System.out.print("Informe o cpf do funcionário: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Olá Sr. " + funcionario.getNome() + ".");
            System.out.print("Informe a senha para liberar acesso: ");

            if (!funcionario.getSenha().equals(input.next())) {
                throw new SenhaIncorretaException();

            } else {
                verificarSenha(funcionario);
            }

        } catch (NullPointerException e) {
            System.out.println("Nenhum funcionário cadastrado com este cpf");
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

            new CadastroMenu(new ArrayList<>(Arrays.asList("Icrud Cliente", "Icrud Funcionário", "Icrud Empresa")), "de Cadastros").executarMenu();
        }
    }

    private static void definirFuncionarioLogado(Funcionario funcionario) {
        if (funcionario != null) {
            System.out.println("~Tenha um ótimo dia de trabalho Sr. " + funcionario.getNome() + "~");
        } else {
            assert false;
            System.out.println("~Espero que tenha tido um ótimo dia de trabalaho Sr. " + funcionario.getNome() + "~");
        }
        funcionarioLogado = funcionario;
    }

    private static void atualizarSenha(Funcionario funcionario) {
        System.out.print("Senhas iguais a cpf ou data de cadastro podem ser vulneráveis é melhor alterar: ");
        funcionario.setSenha(input.next());
        verificarSenha(funcionario);
    }

    // =========================== Cadastrar =========================== //
    public static void cadastrar(byte tentativa) {

        String cpf = null;

        if (tentativa == 0) {
            System.out.println("Desculpe a informção está incorreta.");
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
                Sistema Bancário, onde temos as funcionalidades de um banco como por exemplo: cadastro de conta, login de conta,
                ações bancárias do dia a dia também implementação de uma regra de negócio, nesse caso utilizei investimento\s
                para resaltar essa parte.
                """);

        System.out.println("- Organização: TimeVerde");
        System.out.println("- Autor: Arthur Estevan | Rafael Macedo | Thabata Santos | Erick Gabriel");
        System.out.println("- Versão: GreenBank v2.0");
        System.out.println("- Linguagem: Português");

        System.out.println("============================================");
    }

    // =========================== Recuperação de senha =========================== //
    public static void recuperarSenha(byte tentativa) {

        if (tentativa == 0) {
            System.out.println("Desculpe a informção está incorreta.");
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
            System.out.println("Funcionário atualizado, por favor realize o login:");

            System.out.println("==============================================");

        } catch (NullPointerException e) {

            System.out.println("Nenhum funcionário encontrado com esse CPF.");
            recuperarSenha(--tentativa);
        }
    }
}
