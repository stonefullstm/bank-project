package br.com.banco.dto;

public class ContaDto {
  private String nomeResponsavel;

  public ContaDto(String nomeResponsavel) {
    super();
    this.nomeResponsavel = nomeResponsavel;
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
