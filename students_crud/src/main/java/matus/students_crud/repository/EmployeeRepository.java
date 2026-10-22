package matus.students_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matus.students_crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
