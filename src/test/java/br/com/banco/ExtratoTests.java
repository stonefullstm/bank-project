package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import br.com.banco.model.Extrato;
import br.com.banco.model.Transferencia;

class ExtratoTests {

  @Test
  void deveCriarUmObjetoExtrato() {
    List<Transferencia> transferencias = new ArrayList<Transferencia>();
    Extrato extrato = new Extrato(2000., transferencias);
    assertEquals(extrato.getSaldoTotal(), 2000.);
    assertEquals(extrato.getTransferencias(), transferencias);
  }

}
