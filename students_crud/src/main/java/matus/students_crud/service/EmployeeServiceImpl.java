package matus.students_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matus.students_crud.dao.EmployeeDAO;
import matus.students_crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeDAO edao;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO edao) {
    this.edao = edao;
  }

  @Override
  public List<Employee> findAll() {
    return edao.findAll();
  }
}
