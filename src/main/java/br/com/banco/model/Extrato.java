package br.com.banco.model;

import java.util.List;

public class Extrato {
  private double saldoTotal;
  private List<Transferencia> transferencias;

  public Extrato() {
    super();
  }

  public Extrato(double saldoTotal, List<Transferencia> transferencias) {
    super();
    this.saldoTotal = saldoTotal;
    this.transferencias = transferencias;
  }

  /**
   * @return the saldoTotal
   */
  public double getSaldoTotal() {
    return saldoTotal;
  }

  /**
   * @param saldoTotal the saldoTotal to set
   */
  public void setSaldoTotal(double saldoTotal) {
    this.saldoTotal = saldoTotal;
  }

  /**
   * @return the transferencias
   */
  public List<Transferencia> getTransferencias() {
    return transferencias;
  }

  /**
   * @param transferencias the transferencias to set
   */
  public void setTransferencias(List<Transferencia> transferencias) {
    this.transferencias = transferencias;
  }


}
