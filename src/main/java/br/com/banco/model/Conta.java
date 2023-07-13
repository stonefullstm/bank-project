package br.com.banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CONTA")
  private Long idConta;
  @Column(name = "NOME_RESPONSAVEL", nullable = false)
  private String nomeResponsavel;

  public Conta(String nomeResponsavel) {
    super();
    this.nomeResponsavel = nomeResponsavel;
  }

  /**
   * @return the idConta
   */
  public Long getIdConta() {
    return idConta;
  }

  /**
   * @param idConta the idConta to set
   */
  public void setIdConta(Long idConta) {
    this.idConta = idConta;
  }

  /**
   * @return the nomeResponsavel
   */
  public String getNomeResponsavel() {
    return nomeResponsavel;
  }

  /**
   * @param nomeResponsavel the nomeResponsavel to set
   */
  public void setNomeResponsavel(String nomeResponsavel) {
    this.nomeResponsavel = nomeResponsavel;
  }

}
