package br.com.banco.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
  @Autowired
  TransferenciaRepository transferenciaRepository;

  public List<Transferencia> findAll() {
    return this.transferenciaRepository.findAll();
  }

  public List<Transferencia> findByConta(Conta conta) {
    return this.transferenciaRepository.findByConta(conta);
  }

  public double getSaldoTotal(Conta conta) {
    return this.transferenciaRepository.getSaldoTotal(conta);
  }

  public List<Transferencia> findByContaAndNomeOperadorTransacao(Conta conta,
      String nomeOperadorTransacao) {
    return this.transferenciaRepository.findByContaAndNomeOperadorTransacao(conta,
        nomeOperadorTransacao);
  }

  public List<Transferencia> findByContaAndDataTransferenciaAfter(Conta conta,
      Date dataTransferencia) {
    return this.transferenciaRepository.findByContaAndDataTransferenciaAfter(conta,
        dataTransferencia);
  }
}
