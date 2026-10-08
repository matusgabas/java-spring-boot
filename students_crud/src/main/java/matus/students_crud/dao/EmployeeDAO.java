package matus.students_crud.dao;

import java.util.List;

import matus.students_crud.entity.Employee;

public interface EmployeeDAO {
  List<Employee> findAll();
}
