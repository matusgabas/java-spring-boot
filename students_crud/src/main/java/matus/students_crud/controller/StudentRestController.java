package matus.students_crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import matus.students_crud.entity.Student;
import matus.students_crud.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
  private final StudentService ss;

  @Autowired
  public StudentRestController(StudentService ss) {
    this.ss = ss;
  }

  @GetMapping("")
  public List<Student> getAllStudents() {
    return ss.findAll();
  }

  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable Integer id) {
    Student s = ss.findById(id);
    if (s == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }
    return s;
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Student createStudent(@RequestBody Student s) {
    s.setId(null);
    Student savedS = ss.save(s);
    return savedS;
  }

  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable Integer id, @RequestBody Student s) {
    Student existingS = ss.findById(id);
    if (existingS == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }
    s.setId(id);
    Student updatedS = ss.save(s);
    return updatedS;
  }

  @DeleteMapping("/{id}")
  public Map<String, String> deleteStudent(@PathVariable Integer id) {
    Student s = ss.findById(id);

    if (s == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }

    ss.deleteById(id);
    return Map.of("message", "Deleted student id - " + id);
  }

  @GetMapping("/search")
  public List<Student> searchStudents(@RequestParam String fn, @RequestParam String ln) {
    return ss.findByFirstNameAndLastName(fn, ln);
  }

  @GetMapping("/search-ordered")
  public List<Student> searchOrderedStudents() {
    return ss.getSortedStudents();
  }
}
