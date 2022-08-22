package br.com.entra21.backend.menu;

import java.util.ArrayList;

public class FuncionarioMenu extends GeradorMenu {

    public FuncionarioMenu(ArrayList<String> opcoes, String titulo) {
        super(opcoes, titulo);
    }

    @Override
    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        if (opcao == 2) {
            new ClienteMenu().executarMenu();
        }
        return opcao;
    }
}
