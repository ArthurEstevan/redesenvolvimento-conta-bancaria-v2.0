
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        final byte ZERO = 0;
        byte opcao;


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

        ArrayList<String> opcao = new ArrayList<String>(Arrays.asList("1) Entrar", "2) Cadastrar", "3) Alterar senha", "4) Sobre"));

        if (opcao != null || opcao.isEmpty()) {

            opcao.forEach(System.out::println);
            System.out.println("==========================================");
            System.out.print("selecionei uma opcão: ");
        }
    }
}
