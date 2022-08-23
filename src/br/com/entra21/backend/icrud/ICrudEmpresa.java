package br.com.entra21.backend.icrud;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Empresa;
import br.com.entra21.backend.menu.GeradorMenu;
import java.time.LocalDate;
import java.util.HashMap;


public class ICrudEmpresa extends GeradorMenu implements ICrud<Empresa> {

    public ICrudEmpresa() {
        super(opcoes, "Icrud Empresa");
    }

    @Override
    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        switch (opcao) {
            case 2 -> listar(Armazenar.empresas);
            case 3 -> adicionar();
            case 4 -> exibirDetalhes(buscar(capturarChave()));
            case 5 -> editar(capturarChave());
            case 6 -> deletar(capturarChave());
        }
        return opcao;
    }

    @Override
    public void listar(HashMap<String, Empresa> lista) {
        LocalDate amostra = LocalDate.now();
        System.out.println("\nBem vindo - " + amostra);
        System.out.println("==========================================");
        System.out.println("""

                Dados pessoais
                """);
        for (Empresa empresa : lista.values()) {
            System.out.println(
                    "| " + "Nome: " + empresa.getDono().getNome() + "   " + "Sexo: " + empresa.getDono().getSexo() + "   " + "Data de nascimento: " + empresa.getDono().getDataNascimento() + "   " + "Idade: " + empresa.getDono().getIdade() + '\n' +

                            "| " + "Celular: " + empresa.getDono().getCelular() + "   " + "Email: " + empresa.getDono().getEmail() + "   " + "CPF: " + empresa.getDono().getCpf() + '\n' +
                            "----------------------------------------------------------------------------------------------"
            );
        }
    }

    @Override
    public void adicionar() {
        Cliente cliente = new ICrudCliente().capturarValores();
        Empresa novo = capturarValores();
        novo.setDono(cliente);

        if (buscar(novo) == null) {
            Armazenar.empresas.put(cliente.getCpf(), novo);
            System.out.println("-empresa adicionado-");
        } else {
            System.out.println("Desculpe a informção está incorreta.");
        }
    }

    @Override
    public Empresa buscar(Empresa chave) {
        return Armazenar.empresas.get(chave.getDono().getCpf());
    }

    @Override
    public void editar(Empresa chave) {
        Cliente cliente = new ICrudCliente().atualizar();
        Empresa empresa = capturarValores();
        empresa.setDono(cliente);
        cliente.setCpf(chave.getDono().getCpf());
        empresa.getDono().setCpf(cliente.getCpf());

        Armazenar.empresas.put(chave.getDono().getCpf(),empresa);
        System.out.println("-cliente atualizado-");
    }

    @Override
    public void deletar(Empresa chave) {
        Empresa empresa = buscar(chave);

        // Mantedo posição das chaves no banco de dado consigo ter um controlo de exclusão, como se fosse num sistema de bd, a chave sempre aumenta nunca fica no mesmo lugar de outra chave;
        Empresa bancoDados = new Empresa();
        bancoDados.setDono(chave.getDono());
        // Aqui apenas faço algo mais visual atribuindo ao bancoDados uma visualização da sua chave;
        bancoDados.getDono().setCpf(chave.getDono().getCpf());

        if (empresa == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else {
            Armazenar.empresas.remove(chave.getDono().getCpf());
            Armazenar.empresas.put(chave.getDono().getCpf(), bancoDados);
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public Empresa capturarChave() {
        System.out.println("""

                Dados pessoais
                """);
        for (Empresa empresa : Armazenar.empresas.values()) {
            System.out.println("| " + "Nome: " + empresa.getDono().getNome() + "   " + "CPF: " + empresa.getDono().getCpf() + '\n');
        }

        Cliente cliente = new Cliente();
        Empresa formulario = new Empresa();

        System.out.println("==========================================");
        System.out.print("selecione o CPF: ");
        cliente.setCpf(super.getInput().next());

        formulario.setDono(cliente);

        return formulario;
    }

    @Override
    public Empresa capturarValores() {
        Empresa formulario = new Empresa();

        System.out.print("Informe a razão social: ");
        formulario.setRazapSocial(super.getInput().nextLine());
        formulario.setRazapSocial(super.getInput().nextLine());

        System.out.print("Informe o CNPJ: ");
        formulario.setCnpj(super.getInput().nextLine());

        return formulario;
    }

    @Override
    public void exibirDetalhes(Empresa completo) {
        if (completo == null) {
            System.out.println("Desculpe a informção está incorreta.");
        } else System.out.println(completo.toString());
    }

    @Override
    public Empresa atualizar() {
        return null;
    }

}
