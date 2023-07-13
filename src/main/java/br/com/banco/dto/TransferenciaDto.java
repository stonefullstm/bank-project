package br.com.banco.dto;

import java.util.Date;

public class TransferenciaDto {
  private Date dataTransferencia;
  private double valor;
  private String tipo;
  private String nomeOperadorTransacao;

  public TransferenciaDto(Date dataTransferencia, double valor, String tipo,
      String nomeOperadorTransacao) {
    super();
    this.dataTransferencia = dataTransferencia;
    this.valor = valor;
    this.tipo = tipo;
    this.nomeOperadorTransacao = nomeOperadorTransacao;
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


}
