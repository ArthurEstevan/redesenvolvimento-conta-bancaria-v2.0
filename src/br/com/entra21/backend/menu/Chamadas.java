package br.com.entra21.backend.menu;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.exceptions.SenhaIncorretaException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Chamadas {

    static Scanner input = new Scanner(System.in);
    public static Funcionario funcionarioLogado = null;

    public static void entrar(byte tentativa) {
        if (tentativa == 0) {
            System.out.println("Desculpe a informção está incorreta.");
        } else {
            System.out.println("");
            LocalDate amostra = LocalDate.now();
            System.out.println("Bem vindo - " + amostra + " - 1/" + tentativa);
            System.out.println("==========================================");
        }

        try {

            System.out.print("Informe o cpf do funcionario: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Olá Sr. " + funcionario.getNome() + ".");
            System.out.print("Informe a senha para liberar acesso: ");

            if (!funcionario.getSenha().equals(input.next())) {
                throw new SenhaIncorretaException();
            } else {
                verificarSenha(funcionario);
                return;
            }

        } catch (NullPointerException e) {
            System.out.println("Nenhum funcionario cadastrado com este cpf");
            entrar(tentativa--);
            return;
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
    private static void verificarSenha(Funcionario funcionario) {
        if (funcionario.getSenha().equals(funcionario.getCpf()) || funcionario.getSenha().equals(funcionario.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")))) {
            atualizarSenha(funcionario);
            Armazenar.funcionarios.size();
        } else {
            definirFuncionarioLogado(funcionario);

            System.out.println("VERDADE");
        }
    }
    private static void definirFuncionarioLogado(Funcionario funcionario) {
        if (funcionario != null) {
            System.out.println("Tenha um ótimo dia de trabalho Sr. " + funcionario.getNome());
        } else {
            System.out.println("Espero que tenha tido um ótimo dia de trabalaho Sr. " + funcionario.getNome());
        }
        funcionarioLogado = funcionario;
    }
    private static void atualizarSenha(Funcionario funcionario) {
        System.out.print("Senhas iguais a cpf ou data de cadastro podem ser vulneráveis é melhor alterar: ");
        funcionario.setSenha(input.next());
        verificarSenha(funcionario);
    }
}
