package matus.students_crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import matus.students_crud.entity.Employee;
import matus.students_crud.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private final EmployeeService es;

  public EmployeeRestController(EmployeeService es) {
    this.es = es;
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return es.findAll();
  }
}
