package br.com.banco.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
  List<Transferencia> findByConta(Conta conta);

  @Query("SELECT SUM(t.valor) from Transferencia t where t.conta= ?1")
  double getSaldoTotal(Conta conta);

  @Query("SELECT t FROM Transferencia t WHERE (t.conta = :conta) AND (:operador IS NULL OR t.nomeOperadorTransacao = :operador)"
      + " AND (:dataInicial IS NULL OR t.dataTransferencia >= :dataInicial) AND (:dataFinal IS NULL OR t.dataTransferencia <= :dataFinal)")
  List<Transferencia> findAllByOptionalFilters(Conta conta, Optional<String> operador,
      Optional<Date> dataInicial, Optional<Date> dataFinal);

}
