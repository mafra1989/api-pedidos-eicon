package br.com.eicon.domain.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagensNegociosEnum {

    NUMERO_CONTROLE_EXISTENTE("EIC002","Número de controle {0} já cadastrado."),
    PEDIDO_NAO_ENCONTRADO("EIC003","Pedido não encontrado.");

    private final String codigo;
    private final String mensagem;

}
