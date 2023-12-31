package br.com.banco.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transferencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "DATA_TRANSFERENCIA", nullable = false)
  private Date dataTransferencia;
  @Column
  private double valor;
  @Column
  private String tipo;
  @Column(name = "NOME_OPERADOR_TRANSACAO")
  private String nomeOperadorTransacao;
  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "CONTA_ID")
  private Conta conta;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the dataTransferencia
   */
  public Date getDataTransferencia() {
    return dataTransferencia;
  }

  /**
   * @param dataTransferencia the dataTransferencia to set
   */
  public void setDataTransferencia(Date dataTransferencia) {
    this.dataTransferencia = dataTransferencia;
  }

  /**
   * @return the valor
   */
  public double getValor() {
    return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(double valor) {
    this.valor = valor;
  }

  /**
   * @return the tipo
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * @param tipo the tipo to set
   */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  /**
   * @return the nomeOperadorTransacao
   */
  public String getNomeOperadorTransacao() {
    return nomeOperadorTransacao;
  }

  /**
   * @param nomeOperadorTransacao the nomeOperadorTransacao to set
   */
  public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
    this.nomeOperadorTransacao = nomeOperadorTransacao;
  }

  /**
   * @return the conta
   */
  public Conta getConta() {
    return conta;
  }

  /**
   * @param conta the conta to set
   */
  public void setConta(Conta conta) {
    this.conta = conta;
  }
}
