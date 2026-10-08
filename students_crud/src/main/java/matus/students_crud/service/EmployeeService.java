package matus.students_crud.service;

import java.util.List;

import matus.students_crud.entity.Employee;

public interface EmployeeService {
  List<Employee> findAll();
}
