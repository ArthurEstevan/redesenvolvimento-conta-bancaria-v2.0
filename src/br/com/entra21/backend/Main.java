package br.com.entra21.backend;

import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        final byte ZERO = 0;
        byte opcao;
        Armazenar.inicializarBancoDados();

        do {
            menu();
            try {
                opcao = input.nextByte();
            } catch (InputMismatchException e) {
                opcao = 2;
                input = new Scanner(System.in);
            }

            switch (opcao) {
                case ZERO:
                    System.out.println("Espero que tenha tido uma ótima experiência.");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Desculpe a informção está incorreta.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void menu() {
        System.out.println("");
        LocalDate amostra = LocalDate.now();
        System.out.println("Bem vindo - " + amostra);
        System.out.println("==========================================");
        ArrayList<String> opcao = new ArrayList<String>(Arrays.asList("0) Sair","1) Entrar", "2) Cadastrar", "3) Alterar senha", "4) Sobre"));
        opcao.forEach(System.out::println);
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
    }
}
