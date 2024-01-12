package br.com.eicon.application.pedido;

import br.com.eicon.application.NullaryUseCase;
import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;

import java.util.List;
import java.util.Objects;

public class ListarPedidosUseCase extends NullaryUseCase<ListarPedidosUseCase.Output> {

    private final PedidoPersistenceOutPort pedidoPersistenceOutPort;

    public ListarPedidosUseCase(
            final PedidoPersistenceOutPort pedidoPersistenceOutPort) {
        this.pedidoPersistenceOutPort = Objects.requireNonNull(pedidoPersistenceOutPort);
    }

    @Override
    public ListarPedidosUseCase.Output execute() {
        return new Output(pedidoPersistenceOutPort.listarPedidos());
    }

    public record Output(List<Pedido> pedidos) {
    }
}
