package br.com.db.exception;

public class EntidadeNaoEncontradaException extends Exception{
    public EntidadeNaoEncontradaException() {
    }
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
