package utils.fixtures.models;

import br.com.eicon.domain.models.Pedido;
import br.com.eicon.domain.models.Produto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class PedidoFixture implements TemplateLoader {

    public static final String VALIDO = "VALIDO";

    @Override
    public void load() {
        dtoValido();
    }

    private void dtoValido() {
        Fixture.of(Pedido.class).addTemplate(VALIDO, new Rule() {{
            add("numeroControle", BigInteger.valueOf(1));
            add("dataCadastro", LocalDate.parse("2022-11-11"));
            add("produtos", has(1).of(Produto.class, VALIDO));
            add("codigoCliente", BigInteger.valueOf(1));
            add("valorTotal", BigDecimal.valueOf(83));
        }});
        Fixture.of(Produto.class).addTemplate(VALIDO, new Rule() {{
            add("nome", "Teclado");
            add("valorUnitario", BigDecimal.valueOf(20.75));
            add("quantidade", 4L);
            add("desconto", BigDecimal.ZERO);
        }});
    }
}
