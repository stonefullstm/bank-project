package br.com.banco.exceptions;

public class EntityNaoExistenteException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EntityNaoExistenteException(String msg) {
    super(msg);
  }

}
