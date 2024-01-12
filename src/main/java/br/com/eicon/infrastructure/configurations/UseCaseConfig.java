package br.com.eicon.infrastructure.configurations;

import br.com.eicon.application.mapper.CadastroPedidoInputMapper;
import br.com.eicon.application.pedido.BuscarPedidoUseCase;
import br.com.eicon.application.pedido.ListarPedidosUseCase;
import br.com.eicon.application.pedido.CadastrarPedidoUseCase;
import br.com.eicon.application.pedido.FiltrarPedidosUseCase;
import br.com.eicon.domain.ports.input.ValidacoesInPort;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UseCaseConfig {

    private final CadastroPedidoInputMapper pedidoInputMapper;
    private final ValidacoesInPort validacoesInPort;
    private final PedidoPersistenceOutPort pedidoPersistenceOutPort;

    public UseCaseConfig(final CadastroPedidoInputMapper pedidoInputMapper,
                         final ValidacoesInPort validacoesInPort,
                         final PedidoPersistenceOutPort pedidoPersistenceOutPort) {
        this.validacoesInPort = Objects.requireNonNull(validacoesInPort);
        this.pedidoInputMapper = Objects.requireNonNull(pedidoInputMapper);
        this.pedidoPersistenceOutPort = Objects.requireNonNull(pedidoPersistenceOutPort);
    }

    @Bean
    public ListarPedidosUseCase buscarPedidosUseCase() {
        return new ListarPedidosUseCase(pedidoPersistenceOutPort);
    }

    @Bean
    public CadastrarPedidoUseCase cadastrarPedidoUseCase() {
        return new CadastrarPedidoUseCase(pedidoInputMapper, validacoesInPort, pedidoPersistenceOutPort);
    }

    @Bean
    public BuscarPedidoUseCase buscarPedidoUseCase() {
        return new BuscarPedidoUseCase(pedidoPersistenceOutPort);
    }

    @Bean
    public FiltrarPedidosUseCase filtrarPedidosUseCase() {
        return new FiltrarPedidosUseCase(pedidoPersistenceOutPort);
    }
}
