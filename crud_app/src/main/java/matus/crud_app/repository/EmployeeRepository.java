package matus.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matus.crud_app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
