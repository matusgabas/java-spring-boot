package matus.students_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.students_crud.repository.StudentRepository;
import matus.students_crud.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentRepository sr;

  @Autowired
  public StudentServiceImpl(StudentRepository sr) {
    this.sr = sr;
  }

  @Override
  public List<Student> findAll() {
    return sr.findAll();
  }

  @Override
  public Student findById(int id) {
    return sr.findById(id).orElse(null);
  }

  @Transactional
  @Override
  public Student save(Student student) {
    return sr.save(student);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    sr.deleteById(id);
  }

  @Override
  public List<Student> findByFirstNameAndLastName(String fn, String ln) {
    return sr.findByFirstNameAndLastName(fn, ln);
  }

  @Override
  public List<Student> getSortedStudents() {
    return sr.findAllByOrderByLastNameAsc();
  }
}