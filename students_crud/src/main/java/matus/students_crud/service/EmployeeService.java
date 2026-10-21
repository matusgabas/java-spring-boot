package matus.students_crud.service;

import java.util.List;

import matus.students_crud.entity.Employee;

public interface EmployeeService {
  List<Employee> findAll();

  Employee findById(int id);

  Employee save(Employee e);

  void deleteById(int id);
}
