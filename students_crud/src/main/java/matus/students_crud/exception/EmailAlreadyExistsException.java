package matus.students_crud.exception;

public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException(String e) {
    super("Email " + e + " už existuje");
  }
}
