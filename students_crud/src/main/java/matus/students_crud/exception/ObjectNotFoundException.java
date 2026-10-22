package matus.students_crud.exception;

public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(String objType, Object id) {
    super(objType + " s ID " + id + " nebol nájdený");
  }
}
