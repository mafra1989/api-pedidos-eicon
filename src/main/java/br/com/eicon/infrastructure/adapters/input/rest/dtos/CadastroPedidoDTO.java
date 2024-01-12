package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class CadastroPedidoDTO {

    private List<PedidoDTO> pedidos;
}
