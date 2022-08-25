package br.com.entra21.backend.icrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public interface ICrud<T> {

    LocalDate dataCadastro = LocalDate.now();

    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList("Listar", "Adicionar", "Buscar", "Editar", "Deletar"));

    void listar(HashMap<String, T> lista);

    void adicionar();

    T buscar(T chave);

    void editar(T chave);

    void deletar(T chave);

    T capturarChave();

    T capturarValores();

    void exibirDetalhes(T completo);

    T atualizar();
}
