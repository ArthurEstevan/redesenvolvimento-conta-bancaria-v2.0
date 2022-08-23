package br.com.entra21.backend.menu;

import br.com.entra21.backend.icrud.ICrudCliente;
import java.util.ArrayList;

public class CadastroMenu extends GeradorMenu {

    public CadastroMenu(ArrayList<String> opcoes, String titulo) {
        super(opcoes, titulo);
    }

    @Override
    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        if (opcao == 2) {
            new ICrudCliente().executarMenu();
        }
        return opcao;
    }
}
