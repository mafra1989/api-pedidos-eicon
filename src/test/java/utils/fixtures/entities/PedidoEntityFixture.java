package utils.fixtures.entities;

import br.com.eicon.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import br.com.eicon.infrastructure.adapters.output.persistence.entity.ProdutoEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class PedidoEntityFixture implements TemplateLoader {

    public static final String VALIDO = "VALIDO";

    @Override
    public void load() {
        dtoValido();
    }

    private void dtoValido() {
        Fixture.of(PedidoEntity.class).addTemplate(VALIDO, new Rule() {{
            add("numeroControle", BigInteger.valueOf(1));
            add("dataCadastro", LocalDate.parse("2022-11-11"));
            add("produtos", has(1).of(ProdutoEntity.class, VALIDO));
            add("valorTotal", BigDecimal.valueOf(83));
            add("codigoCliente", BigInteger.valueOf(1));
        }});
        Fixture.of(ProdutoEntity.class).addTemplate(VALIDO, new Rule() {{
            add("nome", "Teclado");
            add("valorUnitario", BigDecimal.valueOf(20.75));
            add("quantidade", 4L);
        }});
    }
}
