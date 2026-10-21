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

  @Override
  public Student findById(int id) {
    Student student = em.find(Student.class, id);
    return student;
  }

  @Override
  public Student save(Student student) {
    Student savedStudent = em.merge(student);
    return savedStudent;
  }

  @Override
  public void deleteById(int id) {
    Student student = em.find(Student.class, id);
    em.remove(student);
  }

  @Override
  public List<Student> findByFirstAndLastName(String fn, String ln) {
    TypedQuery<Student> q = em.createQuery("from Student where firstName like :fn and lastName like :lan",
        Student.class);
    q.setParameter("fn", fn);
    q.setParameter("lan", ln);
    List<Student> students = q.getResultList();
    return students;
  }
}
