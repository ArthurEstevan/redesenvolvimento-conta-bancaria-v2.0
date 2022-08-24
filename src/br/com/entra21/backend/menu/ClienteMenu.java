package br.com.entra21.backend.menu;

import br.com.entra21.backend.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.icrud.ICrudCliente;
import br.com.entra21.backend.sistema.Investimento;
import br.com.entra21.backend.sistema.Operacoes;

public class ClienteMenu extends GeradorMenu implements Operacoes {

    Cliente cliente;

    public ClienteMenu(Cliente cliente) {
        super(opcoes, "de Operações Bancárias");
        this.cliente = cliente;
    }

    @Override
    public byte capturarOpcao() {
        System.out.println("==========================================");
        System.out.print("selecione uma opcão: ");
        byte opcao = super.capturarOpcao();

        switch (opcao) {
            case 2 -> dadosBancario();
            case 3 -> deposito(capturandoValor());
            case 4 -> sacar(capturandoValor());
            case 5 -> transferencia(capturandoValor());
            case 6 -> investimento();
            case 7 -> saldo();
        }
        return opcao;
    }

    @Override
    public void dadosBancario() {
    }

    @Override
    public void deposito(double pValor) {
        System.out.println("========================================");
        System.out.println("Realizar Deposito ");
        System.out.println("========================================");
        System.out.printf("Saldo anterior: " + this.cliente.getSaldo() + "\n");

        this.cliente.setSaldo((this.cliente.getSaldo() + pValor));

        System.out.println("Salado posterior: " + this.cliente.getSaldo());
        System.out.println("========================================");
        System.out.println("-operacao realizada com sucesso-");
    }

    @Override
    public void sacar(double pValor) {
        System.out.println("========================================");
        System.out.println("Realizar Saque");
        System.out.println("========================================");
        System.out.printf("Saldo anterior: " + this.cliente.getSaldo() + "\n");
        if (this.cliente.getSaldo() > pValor) {
            this.cliente.setSaldo((this.cliente.getSaldo() - pValor));
            System.out.print("-operacao realizada com sucesso-\n");
            System.out.print("Saldo posterior: " + this.cliente.getSaldo() + "\n");
        } else {
            System.out.print("-saldo insuficiente-\n");
        }
    }

    @Override
    public void transferencia(double pValor) {
        System.out.println("========================================");
        System.out.println("Realizar Transferencia");

        Cliente informacoes = new ICrudCliente().capturarChave();

        if (pValor <= this.cliente.getSaldo()) {

            if (informacoes.getCpf() != null) {
                this.cliente.setSaldo((this.cliente.getSaldo() - pValor));
                Armazenar.clientes.get(informacoes.getCpf()).setSaldo(Armazenar.clientes.get(informacoes.getCpf()).getSaldo() + pValor);
                System.out.print("-transferencia realizada com sucesso-\n");
            } else {
                System.out.print("-cliente informado não encontrado-");
            }
        } else {
            System.out.print("-saldo insuficiente-");
        }
    }

    @Override
    public void investimento() {
        System.out.println("========================================");
        System.out.println("Realizar Investimento ");
        System.out.println("========================================");

        for (int contador = 0; contador < Investimento.values().length; contador++) {
            System.out.println("Investimento = " + Investimento.values()[contador].name());
            System.out.println("Preco Unitario = " + Investimento.values()[contador].getPrecoUnitario());
            System.out.println("Rentabilidade = " + Investimento.values()[contador].getRentabilidade());
            System.out.println("Data do Vencimento = " + Investimento.values()[contador].getDataDeVencimento() + "\n");
        }

        String opcao;
        double pValorMs, amount;

        System.out.print("Informe o ivestimento: ");
        opcao = super.getInput().next();

        System.out.print("Informe o aporte mensal: ");
        pValorMs = super.getInput().nextDouble();

        switch (opcao) {
            case "TESOURO_IPCA" -> {
                for (int year = 1; year <= 4; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.1703, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                this.cliente.setSaldo((this.cliente.getSaldo() - pValorMs));
            }
            case "TESOURO_SELIC" -> {
                for (int year = 1; year <= 3; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.2445, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                this.cliente.setSaldo((this.cliente.getSaldo() - pValorMs));
            }
            case "TESOURO_PREFIXADO" -> {
                for (int year = 1; year <= 3; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.1264, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                this.cliente.setSaldo((this.cliente.getSaldo() - pValorMs));
            }
        }
    }

    @Override
    public void saldo() {
        System.out.println("========================================");
        System.out.println("Saldo do Cliente");
        System.out.println("========================================");
        System.out.printf("Saldo: " + this.cliente.getSaldo());
    }

    @Override
    public double capturandoValor() {
        System.out.print("\nInforme o valor: ");
        return super.getInput().nextDouble();
    }
}
