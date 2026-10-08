package matus.students_crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import matus.students_crud.entity.Employee;

@Repository
public class EmployeeDAOJpa implements EmployeeDAO {
  private final EntityManager em;

  public EmployeeDAOJpa(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> q = em.createQuery("from Employee", Employee.class);
    List<Employee> employees = q.getResultList();
    return employees;
  }
}
