package matus.students_crud.service;

import java.util.List;

import matus.students_crud.entity.Student;

public interface StudentService {
  List<Student> findAll();
}
