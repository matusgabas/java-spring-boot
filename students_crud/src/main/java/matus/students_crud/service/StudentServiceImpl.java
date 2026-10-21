package matus.students_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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

  @Override
  public Student findById(int id) {
    return sdao.findById(id);
  }

  @Transactional
  @Override
  public Student save(Student student) {
    return sdao.save(student);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    sdao.deleteById(id);
  }

  @Override
  public List<Student> findByFirstAndLastName(String fn, String ln) {
    return sdao.findByFirstAndLastName(fn, ln);
  }
}