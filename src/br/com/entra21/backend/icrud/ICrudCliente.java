package br.com.entra21.backend.icrud;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.menu.GeradorMenu;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ICrudCliente extends GeradorMenu implements ICrud<Cliente> {

    public ICrudCliente() {
        super(opcoes, "Icrud Cliente");
    }

    @Override
    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        switch (opcao) {
            case 2 -> listar(Armazenar.clientes);
            case 3 -> adicionar();
            case 4 -> exibirDetalhes(buscar(capturarChave()));
            case 5 -> editar(capturarChave());
            case 6 -> deletar(capturarChave());
        }
        return opcao;
    }

    @Override
    public void listar(HashMap<String, Cliente> lista) {
        LocalDate amostra = LocalDate.now();
        System.out.println("\nBem vindo - " + amostra);
        System.out.println("==========================================");
        System.out.println("""

                Dados pessoais
                """);
        for (Cliente cliente : lista.values()) {
            System.out.println(
                    "| " + "Nome: " + cliente.getNome() + "   " + "Sexo: " + cliente.getSexo() + "   " + "Data de nascimento: " + cliente.getDataNascimento() + "   " + "Idade: " + cliente.getIdade() + '\n' +

                            "| " + "Celular: " + cliente.getCelular() + "   " + "Email: " + cliente.getEmail() + "   " + "CPF: " + cliente.getCpf() + '\n' +
                            "----------------------------------------------------------------------------------------------"
            );
        }
    }

    @Override
    public void adicionar() {
        Cliente novo = capturarValores();

        if (buscar(novo) == null) {
            Armazenar.clientes.put(novo.getCpf(), novo);
            System.out.println("-cliente adicionado-");
        } else {
            System.out.println("Desculpe a informção está incorreta.");
        }
    }

    @Override
    public Cliente buscar(Cliente chave) {
        return Armazenar.clientes.get(chave.getCpf());
    }

    @Override
    public void editar(Cliente chave) {
        Cliente cliente = atualizar();
        cliente.setCpf(chave.getCpf());


        Armazenar.clientes.put(chave.getCpf(), cliente);
        System.out.println("-cliente atualizado-");
    }

    @Override
    public void deletar(Cliente chave) {
        Cliente cliente = buscar(chave);

        // Mantedo posição das chaves no banco de dado consigo ter um controlo de exclusão, como se fosse num sistema de bd, a chave sempre aumenta nunca fica no mesmo lugar de outra chave;
        Cliente bancoDados = new Cliente();
        // Aqui apenas faço algo mais visual atribuindo ao bancoDados uma visualização da sua chave;
        bancoDados.setCpf(chave.getCpf());

        if (cliente == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else {
            Armazenar.clientes.remove(chave.getCpf());
            Armazenar.clientes.put(chave.getCpf(), bancoDados);
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public Cliente capturarChave() {
        System.out.println("""

                Dados pessoais
                """);
        for (Cliente cliente : Armazenar.clientes.values()) {
            System.out.println("| " + "Nome: " + cliente.getNome() + "   " + "CPF: " + cliente.getCpf() + '\n' +
                               "----------------------------------------------------------------------------------------------");
        }

        Cliente formulario = new Cliente();

        System.out.println("==========================================");
        System.out.print("selecione o CPF: ");
        formulario.setCpf(super.getInput().next());

        return formulario;
    }

    @Override
    public Cliente capturarValores() {
        Cliente formulario = new Cliente();

        byte opcao = 120;
        String numero;

        LocalDate amostra = LocalDate.now();
        System.out.println("\nBem vindo - " + amostra);
        System.out.println("==========================================");

        System.out.print("Informe o nome: ");
        formulario.setNome(super.getInput().next());
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
                numero = "00" + (count + Armazenar.clientes.size());
                formulario.setCpf(numero);
            }
        }
        System.out.print("Informe o RG: ");
        formulario.setRg(super.getInput().next());

        System.out.print("Informe a data de nascimento: ");
        formulario.setDataNascimento(getInput().next());

        System.out.print("Informe o sexo: ");
        formulario.setSexo(super.getInput().next());

        System.out.print("Informe o nome da mãe: ");
        formulario.setMae(super.getInput().next());

        System.out.print("Informe o nome do pai: ");
        formulario.setPai(super.getInput().next());

        System.out.print("Informe o CEP: ");
        formulario.setCep(super.getInput().next());

        System.out.print("Informe o endereço: ");
        formulario.setEndereco(super.getInput().next());

        System.out.print("Informe o numero: ");
        formulario.setNumero(super.getInput().next());

        System.out.print("Informe o bairro: ");
        formulario.setBairro(super.getInput().next());

        System.out.print("Informe a cidade: ");
        formulario.setCidade(super.getInput().next());

        System.out.print("Informe o estado: ");
        formulario.setEstado(super.getInput().next());

        System.out.print("Informe a conta-corrente: ");
        formulario.setContaCorente(super.getInput().next());

        System.out.print("Informe o email: ");
        formulario.setEmail(super.getInput().next());

        formulario.setAgencia("3048");

        formulario.setDataCadastro(amostra);
        return formulario;
    }

    @Override
    public void exibirDetalhes(Cliente completo) {
        if (completo == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else System.out.println(completo.toString());
    }

    @Override
    public Cliente atualizar() {
        Cliente formulario = new Cliente();

        byte opcao = 120;

        LocalDate amostra = LocalDate.now();
        System.out.println("\nBem vindo - " + amostra);
        System.out.println("==========================================");

        System.out.print("Informe o nome: ");
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
        formulario.setDataCadastro(amostra);

        return formulario;
    }
}

