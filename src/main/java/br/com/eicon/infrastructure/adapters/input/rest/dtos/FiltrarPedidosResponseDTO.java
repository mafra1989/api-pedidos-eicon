package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FiltrarPedidosResponseDTO<T> {

    private T pedidos;

    public FiltrarPedidosResponseDTO(T data) {
        super();
        this.pedidos = data;
    }

}