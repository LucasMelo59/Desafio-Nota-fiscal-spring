package br.demo.notafiscal.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String mensagem){
        super(mensagem);
    }
}
