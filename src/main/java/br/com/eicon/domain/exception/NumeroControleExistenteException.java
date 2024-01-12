package br.com.eicon.domain.exception;

public class NumeroControleExistenteException extends BusinessException {

    public NumeroControleExistenteException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}