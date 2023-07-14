package br.com.banco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

  @GetMapping("/{id}")
  public ResponseEntity<List<Transferencia>> findByConta(@PathVariable("id") Long id) {
    var conta = this.contaService.findById(id);
    List<Transferencia> transferencias = this.transferenciaService.findByConta(conta);
    return ResponseEntity.status(HttpStatus.OK).body(transferencias);
  }
}
