package br.com.eicon.infrastructure.adapters.output.persistence.adapter;

import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;
import br.com.eicon.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import br.com.eicon.infrastructure.adapters.output.persistence.mappers.PedidoOutputMapper;
import br.com.eicon.infrastructure.adapters.output.persistence.repository.PedidoRepository;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Interface Adapter
@Component
public class PedidoPersistenceAdapter implements PedidoPersistenceOutPort {

    private final PedidoOutputMapper outputMapper;
    private final PedidoRepository pedidoRepository;

    public PedidoPersistenceAdapter(final PedidoOutputMapper outputMapper,
                                    final PedidoRepository pedidoRepository) {
        this.outputMapper = Objects.requireNonNull(outputMapper);
        this.pedidoRepository = Objects.requireNonNull(pedidoRepository);
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        List<PedidoEntity> entities = pedidoRepository.findAll();
        pedidos = entities.stream().map(entity -> {
            return outputMapper.toDomain(entity);
        }).collect(Collectors.toList());

        return pedidos;
    }

    @Override
    public Pedido buscarPedido(BigInteger numeroControle) {
        PedidoEntity entity = pedidoRepository.findById(numeroControle).orElse(null);
        if(entity != null) {
            return outputMapper.toDomain(entity);
        }
        return null;
    }

    @Override
    public void cadastrarPedidos(List<Pedido> pedidos) {
        List<PedidoEntity> pedidosEntity = pedidos.stream().map(pedido -> {
            return outputMapper.toEntity(pedido);
        }).collect(Collectors.toList());

        pedidoRepository.saveAll(pedidosEntity);
    }

    @Override
    public List<Pedido> filtrarPedidos(LocalDate dataCadastro) {
        List<Pedido> pedidos = new ArrayList<>();

        List<PedidoEntity> entities = pedidoRepository.findByDataCadastro(dataCadastro);
        pedidos = entities.stream().map(entity -> {
            return outputMapper.toDomain(entity);
        }).collect(Collectors.toList());

        return pedidos;
    }
}
