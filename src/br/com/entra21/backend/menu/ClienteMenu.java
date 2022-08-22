package br.com.entra21.backend.menu;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.icrud.ICrud;
import java.util.HashMap;

public class ClienteMenu extends GeradorMenu implements ICrud<Cliente> {

    public ClienteMenu() {
        super(opcoes, "Cliente");
    }

    @Override
    public byte capturarOpcao() {
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

    }

    @Override
    public void adicionar() {

    }

    @Override
    public Cliente buscar(Cliente chave) {
        return null;
    }

    @Override
    public void editar(Cliente chave) {

    }

    @Override
    public void deletar(Cliente chave) {

    }

    @Override
    public Cliente capturarChave() {
        return null;
    }

    @Override
    public Cliente capturarValores() {
        return null;
    }

    @Override
    public void exibirDetalhes(Cliente completo) {

    }
}
