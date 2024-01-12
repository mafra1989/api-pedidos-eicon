package br.com.eicon.infrastructure.adapters.input.rest.controllers;

import br.com.eicon.application.pedido.CadastrarPedidoUseCase;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
import br.com.eicon.infrastructure.adapters.input.rest.exception.enumarator.MensagenInfraestruturaEnum;
import br.com.six2six.fixturefactory.Fixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import utils.FixtureLoader;
import utils.fixtures.dtos.CadastroPedidoDTOFixture;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private CadastrarPedidoUseCase cadastrarPedidoUseCase;

    private ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeAll
    public static void setupScenarios() {
        FixtureLoader.loadAllFixtures();
    }

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(pedidoController).setValidator(Mockito.mock(Validator.class)).build();
    }

    @Test
    public void deveCadastrarPedidoComSucesso() throws Exception {
        // given
        CadastroPedidoDTO inputMock = Fixture.from(CadastroPedidoDTO.class).gimme(CadastroPedidoDTOFixture.VALIDO);

        // then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/pedido/json")
                        .content(objectMapper.writeValueAsString(inputMock))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status")
                        .value(MensagenInfraestruturaEnum.PROCESSADO.getMensagem()));
    }
}
