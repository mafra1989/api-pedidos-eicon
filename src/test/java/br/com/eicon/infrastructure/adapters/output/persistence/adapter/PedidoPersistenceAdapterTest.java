package br.com.eicon.infrastructure.adapters.output.persistence.adapter;

import br.com.eicon.domain.models.Pedido;
import br.com.eicon.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import br.com.eicon.infrastructure.adapters.output.persistence.repository.PedidoRepository;
import br.com.eicon.infrastructure.adapters.output.persistence.mappers.PedidoOutputMapper;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.FixtureLoader;
import utils.fixtures.entities.PedidoEntityFixture;
import utils.fixtures.models.PedidoFixture;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoPersistenceAdapterTest {

    @InjectMocks
    private PedidoPersistenceAdapter pedidoPersistenceAdapter;

    @Spy
    private PedidoOutputMapper outputMapper = Mappers.getMapper(PedidoOutputMapper.class);

    @Mock
    private PedidoRepository pedidoRepository;

    @BeforeAll
    public static void setupScenarios() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    public void deveRetornarPedidoComSucesso() {
        // given
        PedidoEntity pedidoEntityMock = Fixture.from(PedidoEntity.class).gimme(PedidoEntityFixture.VALIDO);

        // when
        when(pedidoRepository.findById(any())).thenReturn(Optional.of(pedidoEntityMock));

        // then
        assertDoesNotThrow(() -> {
            Pedido pedido = pedidoPersistenceAdapter.buscarPedido(BigInteger.valueOf(1));

            assertNotNull(pedido);
            assertEquals(pedidoEntityMock.getNumeroControle(), pedido.getNumeroControle());
        });
    }

    @Test
    public void deveRetornarNullComSucesso() {
        // when
        when(pedidoRepository.findById(any())).thenReturn(Optional.empty());

        // then
        assertDoesNotThrow(() -> {
            Pedido pedido = pedidoPersistenceAdapter.buscarPedido(BigInteger.valueOf(1));

            assertNull(pedido);
        });
    }

    @Test
    public void deveCadastrarPedidoComSucesso() {
        // given
        Pedido pedidoMock = Fixture.from(Pedido.class).gimme(PedidoFixture.VALIDO);
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedidoMock);

        // then
        assertDoesNotThrow(() -> {
            pedidoPersistenceAdapter.cadastrarPedidos(pedidos);
        });
    }
}
