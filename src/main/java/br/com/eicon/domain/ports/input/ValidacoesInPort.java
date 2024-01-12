package br.com.eicon.domain.ports.input;

import java.util.Optional;

public interface ValidacoesInPort<Input> {

    Optional<StringBuilder> execute(Input input);

}