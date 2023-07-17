package br.com.banco;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
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
  void deveRetornarTodasAsTransacoesExistentesNoBanco() throws Exception {
    mockMvc.perform(get("/transferencias").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].valor").value(30895.46))
        .andExpect(jsonPath("$[1].valor").value(12.24));
  }

  @Test
  @Order(2)
  @DisplayName("2 -  Deve retornar todas as transações de uma conta existente no banco de dados.")
  void deveRetornarTodasAsTransacoesDeUmaContaNoBanco() throws Exception {
    mockMvc.perform(get("/transferencias/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.transferencias[0].valor").value(30895.46))
        .andExpect(jsonPath("$.transferencias[1].valor").value(-500.5));
  }

  @Test
  @Order(3)
  @DisplayName("3 -  Deve retornar o saldo total de uma conta existente no banco de dados.")
  void deveRetornarOSaldoTotalDeUmaContaNoBanco() throws Exception {
    mockMvc.perform(get("/transferencias/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.saldoTotal").value(33636.19));
  }

}
