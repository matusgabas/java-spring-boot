package matus.students_crud.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import matus.students_crud.repository.StudentRepository;
import matus.students_crud.entity.Student;
import matus.students_crud.exception.EmailAlreadyExistsException;
import matus.students_crud.exception.ObjectNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentRepository sr;

  public StudentServiceImpl(StudentRepository sr) {
    this.sr = sr;
  }

  @Override
  public List<Student> findAll() {
    return sr.findAll();
  }

  @Override
  public Student findById(int id) {
    return sr.findById(id).orElseThrow(() -> new ObjectNotFoundException("Študent", id));
  }

  @Transactional
  @Override
  public Student save(Student student) {
    if (student.getId() == null) {
      if (sr.existsByEmail(student.getEmail())) {
        throw new EmailAlreadyExistsException(student.getEmail());
      }
    } else {
      Student existingWithEmail = sr.findByEmail(student.getEmail()).orElse(null);
      if (existingWithEmail != null && !Objects.equals(existingWithEmail.getId(), student.getId())) {
        throw new EmailAlreadyExistsException(student.getEmail());
      }
    }

    return sr.save(student);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    if (!sr.existsById(id)) {
      throw new ObjectNotFoundException("Študent", id);
    }
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

  @Override
  public Optional<Student> findByEmail(String e) {
    return sr.findByEmail(e);
  }

  @Override
  public boolean existsByEmail(String e) {
    return sr.existsByEmail(e);
  }
}