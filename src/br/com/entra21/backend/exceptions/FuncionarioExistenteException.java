package br.com.entra21.backend.exceptions;

public class FuncionarioExistenteException extends Exception{

    public FuncionarioExistenteException() {
        super("Desculpe o dados informados já constam em nosso sistema.");
    }
}
