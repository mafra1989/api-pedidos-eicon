package br.com.eicon.application.mapper;

import br.com.eicon.domain.models.CadastroPedido;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CadastroPedidoInputMapper {

	CadastroPedido toDomain(CadastroPedidoDTO dto);
}
