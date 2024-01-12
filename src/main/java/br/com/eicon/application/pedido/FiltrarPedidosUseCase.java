package br.com.eicon.application.pedido;

import br.com.eicon.application.UseCase;
import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class FiltrarPedidosUseCase extends UseCase<FiltrarPedidosUseCase.Input, FiltrarPedidosUseCase.Output> {

    private final PedidoPersistenceOutPort pedidoPersistenceOutPort;

    public FiltrarPedidosUseCase(
            final PedidoPersistenceOutPort pedidoPersistenceOutPort) {
        this.pedidoPersistenceOutPort = Objects.requireNonNull(pedidoPersistenceOutPort);
    }

    @Override
    public FiltrarPedidosUseCase.Output execute(Input input) {
        List<Pedido> pedidos = pedidoPersistenceOutPort
                .filtrarPedidos(LocalDate.parse(input.dataCadastro));
        return new Output(pedidos);
    }

    public record Input(String dataCadastro) {
    }

    public record Output(List<Pedido> pedidos) {
    }
}
