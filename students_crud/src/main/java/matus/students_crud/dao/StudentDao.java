package matus.students_crud.dao;

import java.util.List;

import matus.students_crud.entity.Student;

public interface StudentDao {
  List<Student> findAll();

  Student findById(int id);

  Student save(Student student);

  void deleteById(int id);

  List<Student> findByFirstAndLastName(String fn, String ln);
}
