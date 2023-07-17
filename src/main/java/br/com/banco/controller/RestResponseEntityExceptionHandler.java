package br.com.banco.controller;

import java.util.HashMap;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.banco.exceptions.EntityNaoExistenteException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(EntityNaoExistenteException.class)
  protected ResponseEntity<HashMap<String, String>> handleNotFound(EntityNaoExistenteException ex) {
    HashMap<String, String> response = new HashMap<String, String>();
    response.put("message", ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<HashMap<String, String>> handleConstraintViolationException(
      ConstraintViolationException ex) {
    HashMap<String, String> response = new HashMap<String, String>();
    response.put("message", "Parâmetro url inválido");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

  }
}
