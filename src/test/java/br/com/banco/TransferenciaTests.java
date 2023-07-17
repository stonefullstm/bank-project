package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

class TransferenciaTests {

  @Test
  void deveCriarUmaTransferenciaComConstrutorPadrao() throws ParseException {
    SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
    Transferencia transferencia = new Transferencia();
    Conta conta = new Conta("Beltrano");
    transferencia.setId(1L);
    transferencia.setDataTransferencia(fmtDate.parse("17/07/2023"));
    transferencia.setValor(50.0);
    transferencia.setTipo("SAQUE");
    transferencia.setNomeOperadorTransacao("Fulano");
    transferencia.setConta(conta);
    assertEquals(transferencia.getValor(), 50.0);
    assertEquals(transferencia.getDataTransferencia(), fmtDate.parse("17/07/2023"));
    assertEquals(transferencia.getTipo(), "SAQUE");
    assertEquals(transferencia.getNomeOperadorTransacao(), "Fulano");
    assertEquals(transferencia.getConta(), conta);
  }

}
