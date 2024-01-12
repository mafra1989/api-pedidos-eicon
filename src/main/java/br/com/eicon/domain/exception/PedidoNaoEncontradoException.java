package br.com.eicon.domain.exception;

public class PedidoNaoEncontradoException extends BusinessException {

    public PedidoNaoEncontradoException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}