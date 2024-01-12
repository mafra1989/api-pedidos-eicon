package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CadastroPedidoResponseDTO {

    private LocalDateTime dataResposta = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")));

    private String status;

    public CadastroPedidoResponseDTO(String status) {
        super();
        this.status = status;
    }

}