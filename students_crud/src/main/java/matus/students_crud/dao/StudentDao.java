package matus.students_crud.dao;

import java.util.List;

import matus.students_crud.entity.Student;

public interface StudentDao {
  List<Student> findAll();
}
