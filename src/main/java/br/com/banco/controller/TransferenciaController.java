package br.com.banco.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.banco.model.Extrato;
import br.com.banco.model.Transferencia;
import br.com.banco.service.ContaService;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

  @Autowired
  TransferenciaService transferenciaService;

  @Autowired
  ContaService contaService;

  @GetMapping
  public ResponseEntity<List<Transferencia>> findAll() {
    List<Transferencia> transferencias = this.transferenciaService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(transferencias);
  }

  @CrossOrigin
  @GetMapping("/{id}")
  public ResponseEntity<Extrato> findByConta(@PathVariable("id") Long id,
      @RequestParam Optional<String> operador, @RequestParam Optional<Date> datainicial,
      @RequestParam Optional<Date> datafinal) {
    var conta = this.contaService.findById(id);
    var saldo = this.transferenciaService.getSaldoTotal(conta);
    List<Transferencia> transferencias =
        this.transferenciaService.findAllByOptionalFilters(conta, operador, datainicial, datafinal);
    Extrato extrato = new Extrato(saldo, transferencias);
    return ResponseEntity.status(HttpStatus.OK).body(extrato);
  }
}
