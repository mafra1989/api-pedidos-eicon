package br.com.eicon.domain.ports.output;

import br.com.eicon.domain.models.Pedido;

import java.math.BigInteger;
import java.util.List;

public interface PedidoPersistenceOutPort {

    Pedido buscarPedido(BigInteger numeroControle);

    void cadastrarPedidos(List<Pedido> pedidos);
}
