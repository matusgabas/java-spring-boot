package matus.students_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matus.students_crud.dao.StudentDao;
import matus.students_crud.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentDao sdao;

  @Autowired
  public StudentServiceImpl(StudentDao sdao) {
    this.sdao = sdao;
  }

  @Override
  public List<Student> findAll() {
    return sdao.findAll();
  }
}