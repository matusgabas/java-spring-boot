package matus.students_crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import matus.students_crud.entity.Student;
import matus.students_crud.response.ResponseFactory;
import matus.students_crud.response.ResponseWrapper;
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
  private final ResponseFactory r;

  public StudentRestController(StudentService ss, ResponseFactory r) {
    this.ss = ss;
    this.r = r;
  }

  @GetMapping("")
  public ResponseEntity<ResponseWrapper<List<Student>>> getAllStudents() {
    return r.ok("úspešne získané záznamy", ss.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Student>> getStudentById(@PathVariable Integer id) {
    Student s = ss.findById(id);
    if (s == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }
    return r.ok("úspešne získaný študent", s);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseWrapper<Student>> createStudent(@RequestBody Student s) {
    s.setId(null);
    Student savedS = ss.save(s);
    return r.created("úspešne vytvorený študent", savedS);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Student>> updateStudent(@PathVariable Integer id,
      @Valid @RequestBody Student s) {
    Student existingS = ss.findById(id);
    if (existingS == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }
    s.setId(id);
    Student updatedS = ss.save(s);
    return r.ok("študent úspešne aktualizovaný", updatedS);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseWrapper<Map<String, String>>> deleteStudent(@PathVariable Integer id) {
    Student s = ss.findById(id);

    if (s == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id not found - " + id);
    }

    ss.deleteById(id);
    return r.ok("úspešne vymazaný študent", Map.of("message", "Deleted student id - " + id));
  }

  @GetMapping("/search")
  public ResponseEntity<ResponseWrapper<List<Student>>> searchStudents(@RequestParam String fn,
      @RequestParam String ln) {
    return r.ok("úspešne nájdený", ss.findByFirstNameAndLastName(fn, ln));
  }

  @GetMapping("/search-ordered")
  public ResponseEntity<ResponseWrapper<List<Student>>> searchOrderedStudents() {
    return r.ok("úspešne nájdený", ss.getSortedStudents());
  }
}
