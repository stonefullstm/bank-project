package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Conta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CONTA")
  private Long idConta;
  @Column(name = "NOME_RESPONSAVEL", nullable = false)
  private String nomeResponsavel;
  @JsonManagedReference
  @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  List<Transferencia> transferencias;

  public Conta() {
    super();
    this.transferencias = new ArrayList<Transferencia>();
  }

  public Conta(String nomeResponsavel) {
    super();
    this.nomeResponsavel = nomeResponsavel;
    this.transferencias = new ArrayList<Transferencia>();
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

  /**
   * @return the transferencias
   */
  public List<Transferencia> getTransferencias() {
    return transferencias;
  }

  /**
   * @param transferencia the transferencia to add
   */
  public void addTransferencia(Transferencia transferencia) {
    this.transferencias.add(transferencia);
  }

}
