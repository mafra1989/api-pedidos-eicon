package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuscarPedidosResponseDTO<T> {

    private T pedidos;

    public BuscarPedidosResponseDTO(T data) {
        super();
        this.pedidos = data;
    }

}