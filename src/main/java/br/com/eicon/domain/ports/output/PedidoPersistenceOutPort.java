package br.com.eicon.domain.ports.output;

import br.com.eicon.domain.models.Pedido;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface PedidoPersistenceOutPort {

    List<Pedido> listarPedidos();

    Pedido buscarPedido(BigInteger numeroControle);

    void cadastrarPedidos(List<Pedido> pedidos);

    List<Pedido> filtrarPedidos(LocalDate dataCadastro);
}
