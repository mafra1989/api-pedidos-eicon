package br.com.eicon.domain.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroPedido {

    @Valid
    @NotNull(message = "{campo.notnull}")
    @NotEmpty(message = "{campo.empty}")
    @Size(max = 10, message = "{campo.pedidos.size}")
    private List<Pedido> pedidos;

}
