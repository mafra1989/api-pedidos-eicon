package br.com.eicon.infrastructure.adapters.output.persistence.mappers;

import br.com.eicon.domain.models.Pedido;
import br.com.eicon.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoOutputMapper {

	Pedido toDomain(PedidoEntity entity);

	PedidoEntity toEntity(Pedido domain);

}
