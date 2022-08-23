package br.com.entra21.backend.icrud;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.menu.GeradorMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ICrudFuncionario extends GeradorMenu implements ICrud<Funcionario> {

    public ICrudFuncionario() {
        super(opcoes, "Icrud Funcionário");
    }

    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        switch (opcao) {
            case 2 -> listar(Armazenar.funcionarios);
            case 3 -> adicionar();
            case 4 -> exibirDetalhes(buscar(capturarChave()));
            case 5 -> editar(capturarChave());
            case 6 -> deletar(capturarChave());
        }
        return opcao;
    }

    @Override
    public void listar(HashMap<String, Funcionario> lista) {
        LocalDate amostra = LocalDate.now();
        System.out.println("\nBem vindo - " + amostra);
        System.out.println("==========================================");
        System.out.println("""

                Dados pessoais
                """);
        for (Funcionario funcionario : lista.values()) {
            System.out.println(
                            "| " + "Nome: " + funcionario.getNome() + "   " + "Sexo: " + funcionario.getSexo() + "   " + "Data de nascimento: " + funcionario.getDataNascimento() + "   " + "Idade: " + funcionario.getIdade() + '\n' +

                            "| " + "Celular: " + funcionario.getCelular() + "   " + "Email: " + funcionario.getEmail() + "   " + "CPF: " + funcionario.getCpf() + '\n' +
                            "----------------------------------------------------------------------------------------------"
            );
        }
    }

    @Override
    public void adicionar() {
        Funcionario novo = capturarValores();

        if (buscar(novo) == null) {
            Armazenar.funcionarios.put(novo.getCpf(), novo);
            System.out.println("-funcionário adicionado-");
        } else {
            System.out.println("Desculpe a informção está incorreta.");
        }
    }

    @Override
    public Funcionario buscar(Funcionario chave) {
        return Armazenar.funcionarios.get(chave.getCpf());
    }

    @Override
    public void editar(Funcionario chave) {
        Funcionario funcionario = atualizar();
        funcionario.setCpf(chave.getCpf());

        Armazenar.funcionarios.put(chave.getCpf(),funcionario);
        System.out.println("-cliente atualizado-");
    }

    @Override
    public void deletar(Funcionario chave) {
        Funcionario funcionario = buscar(chave);

        // Mantedo posição das chaves no banco de dado consigo ter um controlo de exclusão, como se fosse num sistema de bd, a chave sempre aumenta nunca fica no mesmo lugar de outra chave;
        Funcionario bancoDados = new Funcionario();
        // Aqui apenas faço algo mais visual atribuindo ao bancoDados uma visualização da sua chave;
        bancoDados.setCpf(chave.getCpf());

        if (funcionario == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else {
            Armazenar.funcionarios.remove(chave.getCpf());
            Armazenar.funcionarios.put(chave.getCpf(), bancoDados);
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public Funcionario capturarChave() {
        System.out.println("""

                Dados pessoais
                """);
        for (Funcionario funcionario : Armazenar.funcionarios.values()) {
            System.out.println("| " + "Nome: " + funcionario.getNome() + "   " + "CPF: " + funcionario.getCpf() + '\n');
        }

        Funcionario formulario = new Funcionario();

        System.out.println("==========================================");
        System.out.print("selecione o CPF: ");
        formulario.setCpf(super.getInput().next());

        return formulario;
    }

    @Override
    public Funcionario capturarValores() {
        Funcionario formulario = new Funcionario();

        byte opcao = 120;
        String numero;
        String[] funcoes = {"DevJunior", "DevPleno", "DevSenior"};

        System.out.println("\nInforme a função\n");
        for (int contador = 0; contador < funcoes.length; contador++) {
            System.out.println((contador + 1) + " - " + funcoes[contador]);
        }
        System.out.println("==========================================");

        System.out.print("Informe a função: ");
        formulario.setNome(super.getInput().nextLine());
        do {
            try {
                System.out.print("Informe a idade: ");
                opcao = super.getInput().nextByte();

            } catch (InputMismatchException e) {
                super.setInput(new Scanner(System.in));
            }
        } while (opcao >= 118 || opcao <= 0);
        formulario.setIdade(opcao);

        // Gerador de cpf para não dar conflito com o cadastro do início do (ementa) que também usa essa função
        // cpf mantém um padrão porque é uma chave codificada passada pelo front-end
        if (formulario.getCpf() == null) {
            for (int count = 1; count < 2; count++) {
                numero = "00" + (count + Armazenar.funcionarios.size());
                formulario.setCpf(numero);
            }
        }
        LocalDate amostrar = LocalDate.now();
        formulario.setDataCadastro(amostrar);

        return formulario;
    }

    @Override
    public void exibirDetalhes(Funcionario completo) {
        if (completo == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else System.out.println(completo.toString());
    }

    @Override
    public Funcionario atualizar() {
        Funcionario formulario = new Funcionario();

        byte opcao = 120;
        String[] funcoes = {"DevJunior", "DevPleno", "DevSenior"};

        System.out.println("\nInforme a função\n");
        for (int contador = 0; contador < funcoes.length; contador++) {
            System.out.println((contador + 1) + " - " + funcoes[contador]);
        }
        System.out.println("==========================================");

        System.out.print("Informe o função: ");
        formulario.setNome(getInput().nextLine());
        formulario.setNome(getInput().nextLine());

        do {
            try {
                System.out.print("Informe a idade: ");
                opcao = super.getInput().nextByte();

            } catch (InputMismatchException e) {
                super.setInput(new Scanner(System.in));
            }
        } while (opcao >= 118 || opcao <= 0);
        formulario.setIdade(opcao);
        LocalDate amostrar = LocalDate.now();
        formulario.setDataCadastro(amostrar);

        return formulario;
    }
}
