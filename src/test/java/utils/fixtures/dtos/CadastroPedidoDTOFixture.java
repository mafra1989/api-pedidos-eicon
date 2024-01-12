package utils.fixtures.dtos;

import br.com.eicon.infrastructure.adapters.input.rest.dtos.CadastroPedidoDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.PedidoDTO;
import br.com.eicon.infrastructure.adapters.input.rest.dtos.ProdutoDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CadastroPedidoDTOFixture implements TemplateLoader {

    public static final String VALIDO = "VALIDO";
    public static final String VALIDO_COM_MAIS_DE_10_PEDIDOS = "VALIDO_COM_MAIS_DE_10_PEDIDOS";

    @Override
    public void load() {
        dtoValido();
        dtoValidoComMaisDe10Pedidos();
    }

    private void dtoValido() {
        Fixture.of(CadastroPedidoDTO.class).addTemplate(VALIDO, new Rule() {{
            add("pedidos", has(1).of(PedidoDTO.class, VALIDO));
        }});
        Fixture.of(PedidoDTO.class).addTemplate(VALIDO, new Rule() {{
            add("numeroControle", BigInteger.valueOf(1));
            add("dataCadastro", "2022-11-11");
            add("produtos", has(1).of(ProdutoDTO.class, VALIDO));
            add("codigoCliente", BigInteger.valueOf(1));
        }});
        Fixture.of(ProdutoDTO.class).addTemplate(VALIDO, new Rule() {{
            add("nome", "Teclado");
            add("valorUnitario", BigDecimal.valueOf(20.75));
            add("quantidade", 4L);
        }});
    }

    private void dtoValidoComMaisDe10Pedidos() {
        Fixture.of(CadastroPedidoDTO.class).addTemplate(VALIDO_COM_MAIS_DE_10_PEDIDOS, new Rule() {{
            add("pedidos", has(11).of(PedidoDTO.class, VALIDO_COM_MAIS_DE_10_PEDIDOS));
        }});
        Fixture.of(PedidoDTO.class).addTemplate(VALIDO_COM_MAIS_DE_10_PEDIDOS, new Rule() {{
            add("numeroControle", BigInteger.valueOf(1));
            add("dataCadastro", "2022-11-11");
            add("produtos", has(1).of(ProdutoDTO.class, VALIDO_COM_MAIS_DE_10_PEDIDOS));
            add("codigoCliente", BigInteger.valueOf(1));
        }});
        Fixture.of(ProdutoDTO.class).addTemplate(VALIDO_COM_MAIS_DE_10_PEDIDOS, new Rule() {{
            add("nome", "Teclado");
            add("valorUnitario", BigDecimal.valueOf(20.75));
            add("quantidade", 4L);
        }});
    }
}
