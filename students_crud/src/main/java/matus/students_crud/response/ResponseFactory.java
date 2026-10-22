package matus.students_crud.response;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {
  public ResponseEntity<ResponseWrapper<Void>> ok(String msg) {
    return ResponseEntity.ok(new ResponseWrapper<>(msg, null, null));
  }

  public <T> ResponseEntity<ResponseWrapper<T>> ok(String msg, T data) {
    return ResponseEntity.ok(new ResponseWrapper<>(msg, data, null));
  }

  public <T> ResponseEntity<ResponseWrapper<T>> created(String msg, T data) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseWrapper<>(msg, data, null));
  }

  public ResponseEntity<ResponseWrapper<Void>> error(HttpStatus sts, String msg) {
    return ResponseEntity.status(sts).body(new ResponseWrapper<>(msg, null, null));
  }

  public ResponseEntity<ResponseWrapper<Void>> error(HttpStatus sts, String msg, List<Map<String, String>> errors) {
    return ResponseEntity.status(sts).body(new ResponseWrapper<>(msg, null, errors));
  }
}
