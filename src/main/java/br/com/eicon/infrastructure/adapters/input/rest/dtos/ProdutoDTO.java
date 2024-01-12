package br.com.eicon.infrastructure.adapters.input.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;
    private BigDecimal valorUnitario;
    private Long quantidade;
}
