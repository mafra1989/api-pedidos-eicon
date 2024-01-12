package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroPedidoDTO {

    private List<PedidoDTO> pedidos;
}
