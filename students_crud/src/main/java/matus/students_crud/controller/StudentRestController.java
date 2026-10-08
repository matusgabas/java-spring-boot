package matus.students_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matus.students_crud.entity.Student;
import matus.students_crud.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class StudentRestController {
  private final StudentService ss;

  @Autowired
  public StudentRestController(StudentService ss) {
    this.ss = ss;
  }

  @GetMapping("/students")
  public List<Student> getAllStudents() {
    return ss.findAll();
  }

}
