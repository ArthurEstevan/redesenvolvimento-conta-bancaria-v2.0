package br.com.entra21.backend.menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeradorMenu {

    static LocalDate dataCadastro = LocalDate.now();
    private Scanner input;
    private ArrayList<String> opcoes;
    private String titulo;

    public GeradorMenu(ArrayList<String> opcoes, String titulo) {
        super();
        this.input = new Scanner(System.in);
        this.opcoes = opcoes;
        this.titulo = titulo;
    }

    public GeradorMenu() {
    }

    public void executarMenu() {
        do {
            System.out.println("\nBem vindo - " + GeradorMenu.getDataCadastro());
            System.out.println("===================== Menu " + this.titulo + " =====================");
            System.out.println("0) Sair");
            System.out.println("1) Voltar");
            if (opcoes != null && !opcoes.isEmpty()) {
                for (int count = 0; count < opcoes.size(); count++) {
                    System.out.println((count + 2) + ") " + opcoes.get(count));
                }
            } else {
                System.out.println("Desculpe a informção está incorreta.");
            }
        } while (capturarOpcao() != 1);
    }

    public byte capturarOpcao() {
        try {
            byte opcao;
            final byte ZERO = 0;
            opcao = input.nextByte();

            switch (opcao) {
                case ZERO -> {
                    System.out.println("Espero que tenha tido uma ótima experiência.");
                    System.exit(ZERO);
                }
                case 1 -> System.out.println("Voltando...");
            }
            return opcao;

        } catch (InputMismatchException e) {
            System.out.println("Valor informado não corresponde ao esperado, tente novamente:");
            input = new Scanner(System.in);
            return capturarOpcao();
        }
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public static LocalDate getDataCadastro() {
        return dataCadastro;
    }
}


