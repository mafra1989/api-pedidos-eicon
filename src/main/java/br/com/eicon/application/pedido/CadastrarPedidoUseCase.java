package br.com.eicon.application.pedido;

import br.com.eicon.application.UnitUseCase;
import br.com.eicon.application.mapper.CadastroPedidoInputMapper;
import br.com.eicon.domain.enumerators.MensagensNegociosEnum;
import br.com.eicon.domain.exception.NumeroControleExistenteException;
import br.com.eicon.domain.exception.ValidationException;
import br.com.eicon.domain.models.CadastroPedido;
import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.input.ValidacoesInPort;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CadastrarPedidoUseCase extends UnitUseCase<CadastrarPedidoUseCase.Input> {

    private final CadastroPedidoInputMapper mapper;
    private final ValidacoesInPort validacoesInPort;
    private final PedidoPersistenceOutPort pedidoPersistenceOutPort;

    public CadastrarPedidoUseCase(
            final CadastroPedidoInputMapper mapper,
            final ValidacoesInPort validacoesInPort,
            final PedidoPersistenceOutPort pedidoPersistenceOutPort) {
        this.mapper = Objects.requireNonNull(mapper);
        this.validacoesInPort = Objects.requireNonNull(validacoesInPort);
        this.pedidoPersistenceOutPort = Objects.requireNonNull(pedidoPersistenceOutPort);
    }

    @Override
    public void execute(Input input) {

        CadastroPedido cadastroPedido = mapper.toDomain(input.dto());

        Optional<StringBuilder> result = validacoesInPort.execute(cadastroPedido);
        if(result.isPresent()) {
            throw new ValidationException("EIC001", result.get().toString());
        }

        List<Pedido> pedidos = cadastroPedido.getPedidos().stream().map(pedido -> {
            Pedido p = pedidoPersistenceOutPort.buscarPedido(pedido.getNumeroControle());
            if(p != null) {
                throw new NumeroControleExistenteException(MensagensNegociosEnum.NUMERO_CONTROLE_EXISTENTE.getCodigo(),
                        MessageFormat.format(MensagensNegociosEnum.NUMERO_CONTROLE_EXISTENTE.getMensagem(), pedido.getNumeroControle()));
            }

            pedido.changeDataCadastro();

            pedido.getProdutos().stream().forEach(produto -> {
                produto.changeQuantidade();
                produto.changeDesconto();
            });

            pedido.changeValorTotal();

            return pedido;
        }).collect(Collectors.toList());

        pedidoPersistenceOutPort.cadastrarPedidos(pedidos);
    }

    public record Input(CadastroPedidoDTO dto) {
    }
}
