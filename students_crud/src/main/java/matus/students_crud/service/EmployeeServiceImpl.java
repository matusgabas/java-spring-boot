package matus.students_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.students_crud.repository.EmployeeRepository;
import matus.students_crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository er;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository er) {
    this.er = er;
  }

  @Override
  public List<Employee> findAll() {
    return er.findAll();
  }

  @Override
  public Employee findById(int id) {
    return er.findById(id).orElse(null);
  }

  @Transactional
  @Override
  public Employee save(Employee e) {
    return er.save(e);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    er.deleteById(id);
  }
}
