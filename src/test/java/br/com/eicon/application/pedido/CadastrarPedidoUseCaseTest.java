package br.com.eicon.application.pedido;

import br.com.eicon.application.mapper.CadastroPedidoInputMapper;
import br.com.eicon.domain.exception.NumeroControleExistenteException;
import br.com.eicon.domain.exception.ValidationException;
import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.ports.input.ValidacoesInPort;
import br.com.eicon.domain.ports.output.PedidoPersistenceOutPort;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
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
import utils.fixtures.dtos.CadastroPedidoDTOFixture;

import java.text.MessageFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastrarPedidoUseCaseTest {

    @InjectMocks
    private CadastrarPedidoUseCase cadastrarPedidoUseCase;

    @Spy
    private CadastroPedidoInputMapper mapper = Mappers.getMapper(CadastroPedidoInputMapper.class);

    @Mock
    private ValidacoesInPort validacoesInPort;

    @Mock
    private PedidoPersistenceOutPort pedidoPersistenceOutPort;

    @BeforeAll
    public static void setupScenarios() {
        FixtureLoader.loadAllFixtures();
    }

    @Test
    public void deveCadastrarPedidoComSucesso() {
        // given
        CadastroPedidoDTO inputMock = Fixture.from(CadastroPedidoDTO.class).gimme(CadastroPedidoDTOFixture.VALIDO);

        assertDoesNotThrow(() -> {
            cadastrarPedidoUseCase.execute(new CadastrarPedidoUseCase.Input(inputMock));
        });
    }

    @Test
    public void deveLancarValidationExceptionQuandoHouverErrosDeValidacao() {
        // given
        CadastroPedidoDTO inputMock = Fixture.from(CadastroPedidoDTO.class).gimme(CadastroPedidoDTOFixture.VALIDO_COM_MAIS_DE_10_PEDIDOS);

        final StringBuilder expectedMessages = new StringBuilder()
                .append("pedidos com quantidade excedida. A quantidade de pedidos deve ser entre 1 e 10/");

        // when
        when(validacoesInPort.execute(any())).thenReturn(
                Optional.of(new StringBuilder().append(expectedMessages)));

        // then
        ValidationException thrown = assertThrows(ValidationException.class, () -> {
            cadastrarPedidoUseCase.execute(new CadastrarPedidoUseCase.Input(inputMock));
        });
        assertEquals(expectedMessages.toString(), thrown.getErrorMessage());
    }

    @Test
    public void deveLancarNumeroControleExistenteExceptionQuandoConsultaRetornarPedido() {
        // given
        CadastroPedidoDTO inputMock = Fixture.from(CadastroPedidoDTO.class).gimme(CadastroPedidoDTOFixture.VALIDO);

        final String expectedMessages = MessageFormat.format(
                "Número de controle {0} já cadastrado.", inputMock.getPedidos().get(0).getNumeroControle());

        // when
        when(validacoesInPort.execute(any())).thenReturn(Optional.empty());
        when(pedidoPersistenceOutPort.buscarPedido(any())).thenReturn(mock(Pedido.class));

        // then
        NumeroControleExistenteException thrown = assertThrows(NumeroControleExistenteException.class, () -> {
            cadastrarPedidoUseCase.execute(new CadastrarPedidoUseCase.Input(inputMock));
        });
        assertEquals(expectedMessages.toString(), thrown.getErrorMessage());
    }
}
