package br.com.eicon.infrastructure.adapters.output.persistence.repository;

import br.com.eicon.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, BigInteger> {

    List<PedidoEntity> findByDataCadastro(LocalDate dataCadastro);
}
