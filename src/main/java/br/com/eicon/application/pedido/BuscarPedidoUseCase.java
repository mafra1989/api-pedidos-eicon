package br.com.eicon.application.pedido;

import br.com.eicon.application.UseCase;
import br.com.eicon.domain.enumerators.MensagensNegociosEnum;
import br.com.eicon.domain.exception.PedidoNaoEncontradoException;
import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;

import java.math.BigInteger;
import java.util.Objects;

public class BuscarPedidoUseCase extends UseCase<BuscarPedidoUseCase.Input, BuscarPedidoUseCase.Output> {

    private final PedidoPersistenceOutPort pedidoPersistenceOutPort;

    public BuscarPedidoUseCase(
            final PedidoPersistenceOutPort pedidoPersistenceOutPort) {
        this.pedidoPersistenceOutPort = Objects.requireNonNull(pedidoPersistenceOutPort);
    }

    @Override
    public BuscarPedidoUseCase.Output execute(Input input) {
        Pedido pedido = pedidoPersistenceOutPort.buscarPedido(input.numeroControle);

        if(pedido == null) {
            throw new PedidoNaoEncontradoException(MensagensNegociosEnum.PEDIDO_NAO_ENCONTRADO.getCodigo(),
                    MensagensNegociosEnum.PEDIDO_NAO_ENCONTRADO.getMensagem());
        }

        return new Output(pedido);
    }

    public record Input(BigInteger numeroControle) {
    }

    public record Output(Pedido pedido) {
    }
}
