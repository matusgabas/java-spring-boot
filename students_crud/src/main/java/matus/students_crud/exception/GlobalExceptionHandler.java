package matus.students_crud.exception;

import java.util.List;
import java.util.Map;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import matus.students_crud.response.ResponseFactory;
import matus.students_crud.response.ResponseWrapper;

@RestControllerAdvice
public class GlobalExceptionHandler {
  private final ResponseFactory r;

  public GlobalExceptionHandler(ResponseFactory r) {
    this.r = r;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseWrapper<Void>> handleValidation(MethodArgumentNotValidException ex) {
    List<Map<String, String>> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> Map.of(
            "field", error.getField(),
            "message", error.getDefaultMessage()))
        .toList();

    return r.error(HttpStatus.BAD_REQUEST, "Validačné chyby", errors);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ResponseWrapper<Void>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    String msg = "Parameter '" + ex.getName() + "' má neplatnú hodnotu";
    return r.error(HttpStatus.BAD_REQUEST, msg);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseWrapper<Void>> handleGeneral(Exception ex) {
    return r.error(HttpStatus.INTERNAL_SERVER_ERROR, "Nastala neočakávaná chyba");
  }

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<ResponseWrapper<Void>> handleObjectNotFound(ObjectNotFoundException ex) {
    return r.error(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ResponseEntity<ResponseWrapper<Void>> handleEmailExists(EmailAlreadyExistsException ex) {
    List<Map<String, String>> errors = List.of(
        Map.of("field", "email", "message", ex.getMessage()));
    return r.error(HttpStatus.CONFLICT, "Email už existuje", errors);
  }
}
