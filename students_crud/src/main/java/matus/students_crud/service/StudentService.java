package matus.students_crud.service;

import java.util.List;
import java.util.Optional;

import matus.students_crud.entity.Student;

public interface StudentService {
  List<Student> findAll();

  Student findById(int id);

  Student save(Student student);

  void deleteById(int id);

  List<Student> findByFirstNameAndLastName(String fn, String ln);

  List<Student> getSortedStudents();

  Optional<Student> findByEmail(String email);

  boolean existsByEmail(String email);
}
