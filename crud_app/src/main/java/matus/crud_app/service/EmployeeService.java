package matus.crud_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.crud_app.entity.Employee;
import matus.crud_app.repository.EmployeeRepository;

@Service
public class EmployeeService {
  private final EmployeeRepository er;

  public EmployeeService(EmployeeRepository er) {
    this.er = er;
  }

  public List<Employee> findAll() {
    return er.findAll();
  }

  public Employee findById(Integer id) {
    return er.findById(id).orElseThrow(() -> new RuntimeException());
  }

  @Transactional
  public Employee save(Employee e) {
    return er.save(e);
  }

  @Transactional
  public void deleteById(int id) {
    if (!er.existsById(id)) {
      throw new RuntimeException();
    }
    er.deleteById(id);
  }
}
