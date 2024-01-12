package br.com.eicon.infrastructure.adapters.input.rest.controllers;


import br.com.eicon.application.pedido.BuscarPedidoUseCase;
import br.com.eicon.application.pedido.ListarPedidosUseCase;
import br.com.eicon.application.pedido.CadastrarPedidoUseCase;
import br.com.eicon.application.pedido.FiltrarPedidosUseCase;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.BuscarPedidoResponseDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.BuscarPedidosResponseDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoResponseDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.FiltrarPedidosResponseDTO;
import br.com.eicon.infrastructure.adapters.input.rest.exception.enumarator.MensagenInfraestruturaEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Objects;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final ListarPedidosUseCase listarPedidosUseCase;
    private final CadastrarPedidoUseCase cadastrarPedidoUseCase;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final FiltrarPedidosUseCase filtrarPedidosUseCase;

    public PedidoController(final ListarPedidosUseCase listarPedidosUseCase,
                            final CadastrarPedidoUseCase cadastrarPedidoUseCase,
                            final BuscarPedidoUseCase buscarPedidoUseCase,
                            final FiltrarPedidosUseCase filtrarPedidosUseCase) {
        this.listarPedidosUseCase = Objects.requireNonNull(listarPedidosUseCase);
        this.cadastrarPedidoUseCase = Objects.requireNonNull(cadastrarPedidoUseCase);
        this.buscarPedidoUseCase = Objects.requireNonNull(buscarPedidoUseCase);
        this.filtrarPedidosUseCase = Objects.requireNonNull(filtrarPedidosUseCase);
    }

    @GetMapping
    public ResponseEntity<?> listarPedidos() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new BuscarPedidosResponseDTO(listarPedidosUseCase.execute()).getPedidos());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> cadastrarPedido(@RequestBody CadastroPedidoDTO dto) {
        cadastrarPedidoUseCase.execute(new CadastrarPedidoUseCase.Input(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new CadastroPedidoResponseDTO(MensagenInfraestruturaEnum.PROCESSADO.getMensagem()));
    }

    @GetMapping("/{numeroControle}")
    public ResponseEntity<?> buscarPedido(@PathVariable BigInteger numeroControle) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new BuscarPedidoResponseDTO(buscarPedidoUseCase.execute(
                        new BuscarPedidoUseCase.Input(numeroControle)).pedido()));
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> filtrarPedidos(@RequestParam String dataCadastro) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new FiltrarPedidosResponseDTO(filtrarPedidosUseCase.execute(
                        new FiltrarPedidosUseCase.Input(dataCadastro)).pedidos()));
    }
}
