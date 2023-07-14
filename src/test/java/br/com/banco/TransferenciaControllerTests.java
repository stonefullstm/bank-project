package br.com.banco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import br.com.banco.repository.TransferenciaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransferenciaControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private TransferenciaRepository transferenciaRepository;

  @Test
  @Order(1)
  @DisplayName("1 -  Deve retornar todas as transações existentes no banco de dados.")
  void deveRetornarTodasAsTransacoesExistentesNoBanco() {}
}
