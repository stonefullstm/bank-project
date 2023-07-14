package br.com.banco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
  List<Transferencia> findByConta(Conta conta);

  @Query("SELECT SUM(t.valor) from Transferencia t where t.conta= ?1")
  double getSaldoTotal(Conta conta);

  List<Transferencia> findByContaAndNomeOperadorTransacao(Conta conta,
      String nomeOperadorTransacao);
}
