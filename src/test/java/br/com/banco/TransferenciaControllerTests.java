package br.com.banco;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.text.SimpleDateFormat;
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
import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransferenciaControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private TransferenciaRepository transferenciaRepository;

  @SpyBean
  private ContaRepository contaRepository;

  // @BeforeEach
  // public void setup() {
  // transferenciaRepository.deleteAll();
  // }

  @Test
  @Order(1)
  @DisplayName("1 -  Deve retornar todas as transações existentes no banco de dados.")
  void deveRetornarTodasAsTransacoesExistentesNoBanco() throws Exception {
    transferenciaRepository.deleteAll();
    contaRepository.deleteAll();
    SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
    Conta conta = new Conta();
    conta.setIdConta(3L);
    conta.setNomeResponsavel("Sicrano");
    contaRepository.save(conta);

    Transferencia transferencia = new Transferencia();
    transferencia.setId(1L);
    transferencia.setDataTransferencia(fmtDate.parse("17/06/2023"));
    transferencia.setValor(1500.0);
    transferencia.setTipo("DEPOSITO");
    transferencia.setConta(conta);
    transferenciaRepository.save(transferencia);

    Transferencia transferencia1 = new Transferencia();
    transferencia1.setId(2L);
    transferencia1.setDataTransferencia(fmtDate.parse("10/07/2023"));
    transferencia1.setValor(-150.0);
    transferencia1.setTipo("SAQUE");
    transferencia1.setConta(conta);
    transferenciaRepository.save(transferencia1);

    mockMvc.perform(get("/transferencias").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].valor").value(1500.00))
        .andExpect(jsonPath("$[1].valor").value(-150.00));
  }

  @Test
  @Order(2)
  @DisplayName("2 - Deve retornar todas as transações de uma conta existente no banco de dados.")
  void deveRetornarTodasAsTransacoesDeUmaContaNoBanco() throws Exception {
    mockMvc.perform(get("/transferencias/3").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.transferencias", hasSize(2)))
        .andExpect(jsonPath("$.transferencias[0].valor").value(1500.00))
        .andExpect(jsonPath("$.transferencias[1].valor").value(-150.00));
  }

  @Test
  @Order(3)
  @DisplayName("3 - Deve retornar o saldo total de uma conta existente no banco de dados.")
  void deveRetornarOSaldoTotalDeUmaContaNoBanco() throws Exception {
    mockMvc.perform(get("/transferencias/3").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.saldoTotal").value(1350.00));
  }

  @Test
  @Order(4)
  @DisplayName("4 - Deve retornar \"Conta não encontrada\" quando não houver Conta com dado id.")
  void deveRetornarNaoEncontradoQuandoNaoHouverContaComDadoId() throws Exception {
    mockMvc.perform(get("/transferencias/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("Conta não encontrada"));
  }

  @Test
  @Order(5)
  @DisplayName("5 - Deve retornar todas as transações de uma conta com um dado operador.")
  void deveRetornarTodasAsTransacoesDeUmaContaComUmDadoOperador() throws Exception {
    Conta conta = contaRepository.getById(3L);
    SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
    Transferencia transferencia2 = new Transferencia();
    transferencia2.setId(3L);
    transferencia2.setDataTransferencia(fmtDate.parse("12/07/2023"));
    transferencia2.setValor(500.0);
    transferencia2.setTipo("TRANSFERENCIA");
    transferencia2.setNomeOperadorTransacao("Fulano");
    transferencia2.setConta(conta);
    transferenciaRepository.save(transferencia2);
    mockMvc
        .perform(get("/transferencias/3?operador=Fulano").contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.transferencias", hasSize(1)))
        .andExpect(jsonPath("$.saldoTotal").value(1850.00))
        .andExpect(jsonPath("$.transferencias[0].valor").value(500.0));
  }

  @Test
  @Order(6)
  @DisplayName("6 - Deve retornar todas as transações de uma conta com um operador num intervalo de datas.")
  void deveRetornarTodasAsTransacoesDeUmaContaComUmOperadorNumIntervaloDeDatas() throws Exception {
    mockMvc
        .perform(
            get("/transferencias/3?operador=Fulano&datainicial=16/06/2023&datafinal=12/07/2023")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.transferencias", hasSize(1)))
        .andExpect(jsonPath("$.saldoTotal").value(1850.0))
        .andExpect(jsonPath("$.transferencias[0].valor").value(500.0));
  }

  @Test
  @Order(7)
  @DisplayName("7 - Deve retornar todas as transações de uma conta num intervalo de datas.")
  void deveRetornarTodasAsTransacoesDeUmaContaNumIntervaloDeDatas() throws Exception {
    mockMvc
        .perform(get("/transferencias/3?datainicial=16/06/2023&datafinal=17/07/2023")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.transferencias", hasSize(3)))
        .andExpect(jsonPath("$.saldoTotal").value(1850.0))
        .andExpect(jsonPath("$.transferencias[0].valor").value(1500.0));
  }

}
