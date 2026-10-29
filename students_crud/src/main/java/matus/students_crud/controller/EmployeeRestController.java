package matus.students_crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import matus.students_crud.entity.Employee;
import matus.students_crud.response.ResponseFactory;
import matus.students_crud.response.ResponseWrapper;
import matus.students_crud.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
  private final EmployeeService es;
  private final ResponseFactory r;

  public EmployeeRestController(EmployeeService es, ResponseFactory r) {
    this.es = es;
    this.r = r;
  }

  @GetMapping("")
  public ResponseEntity<ResponseWrapper<List<Employee>>> getAllEmployees() {
    return r.ok("Načítané", es.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Employee>> getEmployeeById(@PathVariable Integer id) {
    Employee e = es.findById(id);
    if (e == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
    }
    return r.ok("Zamestnanec získaný", e);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@Valid @RequestBody Employee e) {
    e.setId(null);
    Employee savedE = es.save(e);
    return r.created("Zamestnanec vytvorený", savedE);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@PathVariable Integer id,
      @Valid @RequestBody Employee e) {
    Employee existingE = es.findById(id);
    if (existingE == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
    }

    e.setId(id);
    Employee updatedE = es.save(e);
    return r.ok("Zamestnanec upravený", updatedE);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Map<String, String>>> deleteEmployee(@PathVariable Integer id) {
    Employee e = es.findById(id);
    if (e == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
    }

    es.deleteById(id);
    return r.ok("Zamestnanec vymazaný", Map.of("message", "Deleted employee id - " + id));
  }
}
