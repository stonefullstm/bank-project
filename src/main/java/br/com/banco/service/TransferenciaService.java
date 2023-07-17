package br.com.banco.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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

  public double getSaldoTotal(Conta conta) {
    return this.transferenciaRepository.getSaldoTotal(conta);
  }

  public List<Transferencia> findAllByOptionalFilters(Conta conta,
      Optional<String> nomeOperadorTransacao, Optional<Date> dataTransferenciaInicial,
      Optional<Date> dataTransferenciaFinal) {

    return this.transferenciaRepository.findAllByOptionalFilters(conta, nomeOperadorTransacao,
        dataTransferenciaInicial, dataTransferenciaFinal);
  }

}
