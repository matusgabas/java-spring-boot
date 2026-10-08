package matus.students_crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import matus.students_crud.entity.Student;

@Repository
public class StudentDAOJpaImpl implements StudentDao {
  private final EntityManager em;

  @Autowired
  public StudentDAOJpaImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> q = em.createQuery("from Student", Student.class);
    List<Student> students = q.getResultList();
    return students;
  }
}
