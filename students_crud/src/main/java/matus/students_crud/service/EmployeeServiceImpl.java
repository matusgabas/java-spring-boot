package matus.students_crud.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.students_crud.repository.EmployeeRepository;
import matus.students_crud.entity.Employee;
import matus.students_crud.exception.EmailAlreadyExistsException;
import matus.students_crud.exception.ObjectNotFoundException;

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
    return er.findById(id).orElseThrow(() -> new ObjectNotFoundException("Zamestnanec", id));
  }

  @Transactional
  @Override
  public Employee save(Employee e) {
    if (e.getId() == null) {
      if (er.existsByEmail(e.getEmail())) {
        throw new EmailAlreadyExistsException(e.getEmail());
      }
    } else {
      Employee existingWithEmail = er.findByEmail(e.getEmail()).orElse(null);
      if (existingWithEmail != null && !Objects.equals(existingWithEmail.getId(), e.getId())) {
        throw new EmailAlreadyExistsException(e.getEmail());
      }
    }
    return er.save(e);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    if (!er.existsById(id)) {
      throw new ObjectNotFoundException("Zamestnanec", id);
    }
    er.deleteById(id);
  }

  @Override
  public Optional<Employee> findByEmail(String e) {
    return er.findByEmail(e);
  }

  @Override
  public boolean existsByEmail(String e) {
    return er.existsByEmail(e);
  }
}
