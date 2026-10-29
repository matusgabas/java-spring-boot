package matus.crud_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.crud_app.entity.Student;
import matus.crud_app.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository sr;

  public StudentService(StudentRepository sr) {
    this.sr = sr;
  }

  public List<Student> findAll() {
    return sr.findAll();
  }

  public Student findById(int id) {
    return sr.findById(id).orElseThrow(() -> new RuntimeException());
  }

  @Transactional
  public Student save(Student student) {
    return sr.save(student);
  }

  @Transactional
  public void deleteById(int id) {
    if (!sr.existsById(id)) {
      throw new RuntimeException();
    }
    sr.deleteById(id);
  }
}
