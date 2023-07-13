package br.com.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContaRepositoryTests {

  @SpyBean
  private ContaRepository contaRepository;

  @BeforeEach
  public void setup() {
    contaRepository.deleteAll();
  }

  @Test
  @Order(1)
  @DisplayName("1 -  Deve adicionar uma conta no banco de dados.")
  void deveAdicionarUmaContaNoBanco() {
    Conta conta = new Conta(1, "Fulano de Tal");
    contaRepository.save(conta);
    Conta contaInserida = contaRepository.getById(1);
    assertEquals("Fulano de Tal", contaInserida.getNomeResponsavel());
  }
}
