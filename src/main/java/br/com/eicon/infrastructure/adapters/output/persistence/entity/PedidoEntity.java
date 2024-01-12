package br.com.eicon.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedido")
@Table(name = "TB_PEDIDO")
public class PedidoEntity {

    @Id
    private BigInteger numeroControle;

    private LocalDate dataCadastro;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoEntity> produtos;

    private BigDecimal valorTotal;
    private BigInteger codigoCliente;
}
