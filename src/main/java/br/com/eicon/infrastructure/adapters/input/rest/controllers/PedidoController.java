package br.com.eicon.infrastructure.adapters.input.rest.controllers;


import br.com.eicon.application.pedido.CadastrarPedidoUseCase;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoResponseDTO;
import br.com.eicon.infrastructure.adapters.input.rest.exception.enumarator.MensagenInfraestruturaEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PedidoController {

    private final CadastrarPedidoUseCase cadastrarPedidoUseCase;

    public PedidoController(final CadastrarPedidoUseCase cadastrarPedidoUseCase) {
        this.cadastrarPedidoUseCase = Objects.requireNonNull(cadastrarPedidoUseCase);
    }

    @PostMapping("/pedido/json")
    public ResponseEntity<?> cadastrarPedido(@RequestBody CadastroPedidoDTO dto) {

        cadastrarPedidoUseCase.execute(new CadastrarPedidoUseCase.Input(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(new CadastroPedidoResponseDTO(MensagenInfraestruturaEnum.PROCESSADO.getMensagem()));
    }
}
