package matus.students_crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import matus.students_crud.entity.Employee;
import matus.students_crud.service.EmployeeService;

import org.springframework.http.HttpStatus;
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

  public EmployeeRestController(EmployeeService es) {
    this.es = es;
  }

  @GetMapping("")
  public List<Employee> getAllEmployees() {
    return es.findAll();
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable Integer id) {
    return es.findById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee createEmployee(@RequestBody Employee e) {
    e.setId(null);
    Employee savedE = es.save(e);
    return savedE;
  }

  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee e) {
    Employee existingE = es.findById(id);
    if (existingE == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
    }

    e.setId(id);
    Employee updatedE = es.save(e);
    return updatedE;
  }

  @DeleteMapping("/{id}")
  public Map<String, String> deleteEmployee(@PathVariable Integer id) {
    Employee e = es.findById(id);
    if (e == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + id);
    }

    es.deleteById(id);
    return Map.of("message", "Deleted employee id - " + id);
  }
}
