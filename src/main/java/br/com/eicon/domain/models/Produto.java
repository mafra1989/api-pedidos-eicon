package br.com.eicon.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private static final BigInteger QUANTIDADE_DEFAULT = BigInteger.valueOf(1L);
    private static final BigDecimal DESCONTO_5 = BigDecimal.valueOf(5L);
    private static final BigDecimal DESCONTO_10 = BigDecimal.valueOf(10L);

    @NotNull(message = "{campo.notnull}")
    @NotBlank(message = "{campo.notblank}")
    private String nome;

    @NotNull(message = "{campo.notnull}")
    private BigDecimal valorUnitario;

    private Long quantidade;

    private BigDecimal desconto = BigDecimal.ZERO;

    public void changeQuantidade() {
        if(this.getQuantidade() == null) {
            this.setQuantidade(QUANTIDADE_DEFAULT.longValue());
        }
    }

    public void changeDesconto() {
        if(this.getQuantidade() >= DESCONTO_10.longValue()) {
            this.setDesconto(DESCONTO_10);
        } else if(this.getQuantidade() > DESCONTO_5.longValue()) {
            this.setDesconto(DESCONTO_5);
        }
    }
}
