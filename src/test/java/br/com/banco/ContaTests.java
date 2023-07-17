package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

class ContaTests {

  @Test
  void deveCriarUmaContaComConstrutorPadrao() {
    Conta conta = new Conta();
    conta.setIdConta(1L);
    conta.setNomeResponsavel("Sicrano");
    assertEquals(conta.getIdConta(), 1L);
    assertEquals(conta.getNomeResponsavel(), "Sicrano");
    assertEquals(conta.getTransferencias(), new ArrayList<Transferencia>());
  }

  @Test
  void deveCriarUmaContaComConstrutorComParametros() {
    Conta conta = new Conta("Sicrano");
    assertEquals(conta.getNomeResponsavel(), "Sicrano");
    assertEquals(conta.getTransferencias(), new ArrayList<Transferencia>());
  }
}
