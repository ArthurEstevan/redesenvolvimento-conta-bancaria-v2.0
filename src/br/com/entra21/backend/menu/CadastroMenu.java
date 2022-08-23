package br.com.entra21.backend.menu;

import br.com.entra21.backend.icrud.ICrudCliente;
import br.com.entra21.backend.icrud.ICrudEmpresa;
import br.com.entra21.backend.icrud.ICrudFuncionario;

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

        switch (opcao) {
            case 2 -> new ICrudCliente().executarMenu();
            case 3 -> new ICrudFuncionario().executarMenu();
            case 4 -> new ICrudEmpresa().executarMenu();
        }
        return opcao;
    }
}
