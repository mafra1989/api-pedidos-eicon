package br.com.eicon.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @NotNull(message = "{campo.notnull}")
    private BigInteger numeroControle;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataCadastro;

    @Valid
    @NotNull(message = "{campo.notnull}")
    @NotEmpty(message = "{campo.empty}")
    private List<Produto> produtos;

    @NotNull(message = "{campo.notnull}")
    private BigInteger codigoCliente;

    private BigDecimal valorTotal = BigDecimal.ZERO;

    public void changeDataCadastro() {
        if(this.getDataCadastro() == null) {
            this.setDataCadastro(LocalDateTime.now());
        }
    }

    public void changeValorTotal() {
        this.getProdutos().stream().forEach(produto -> {
            BigDecimal total = new BigDecimal(produto.getValorUnitario().doubleValue()
                    * produto.getQuantidade().longValue());

            BigDecimal desconto = new BigDecimal(total.doubleValue()
                    * produto.getDesconto().doubleValue()/100);

            BigDecimal subtotal = new BigDecimal(total.doubleValue() - desconto.doubleValue());

            this.setValorTotal(this.getValorTotal().add(subtotal));
        });
    }
}
