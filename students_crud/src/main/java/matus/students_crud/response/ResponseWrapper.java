package matus.students_crud.response;

import java.util.List;
import java.util.Map;

public class ResponseWrapper<T> {
  private String msg;
  private T data;
  private List<Map<String, String>> errors;

  public ResponseWrapper(String msg, T data, List<Map<String, String>> errors) {
    this.msg = msg;
    this.data = data;
    this.errors = errors;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public List<Map<String, String>> getErrors() {
    return errors;
  }

  public void setErrors(List<Map<String, String>> errors) {
    this.errors = errors;
  }

}
