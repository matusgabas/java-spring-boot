package matus.crud_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import matus.crud_app.entity.Student;
import matus.crud_app.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
  private final StudentService ss;

  public StudentController(StudentService ss) {
    this.ss = ss;
  }

  @GetMapping
  public String listStudents(Model m) {
    List<Student> s = ss.findAll();
    m.addAttribute("students", s);
    return "list";
  }

  @GetMapping("/{id}")
  public String viewStudent(@PathVariable Integer id, Model m) {
    Student s = ss.findById(id);
    m.addAttribute("student", s);
    return "view";
  }

  @GetMapping("/create")
  public String showCreateForm(Model m) {
    m.addAttribute("student", new Student());
    return "form";
  }

  @PostMapping
  public String createStudent(@ModelAttribute("student") Student s) {
    s.setId(null);
    ss.save(s);
    return "redirect:/students";
  }

  @PostMapping("/{id}/delete")
  public String deleteStudent(@PathVariable Integer id) {
    ss.deleteById(id);
    return "redirect:/students";
  }

  @GetMapping("/{id}/edit")
  public String showUpdateForm(@PathVariable Integer id, Model m) {
    Student s = ss.findById(id);
    m.addAttribute("student", s);
    return "form";
  }

  @PostMapping("/{id}")
  public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student s) {
    ss.findById(id);
    s.setId(id);
    ss.save(s);
    return "redirect:/students";
  }

}
